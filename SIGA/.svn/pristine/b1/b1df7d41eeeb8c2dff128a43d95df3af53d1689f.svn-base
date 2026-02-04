package com.meve.oracle.cm;

/*
 * Copyright (c) 2005, Oracle. All rights reserved.  
 */

import java.net.MalformedURLException;
import java.net.URL;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import oracle.ifs.fdk.CategoryManager;
import oracle.ifs.fdk.CategoryManagerServiceLocator;
import oracle.ifs.fdk.CommonManager;
import oracle.ifs.fdk.CommonManagerServiceLocator;
import oracle.ifs.fdk.ContainerManager;
import oracle.ifs.fdk.ContainerManagerServiceLocator;
import oracle.ifs.fdk.DomainManager;
import oracle.ifs.fdk.DomainManagerServiceLocator;
import oracle.ifs.fdk.FdkException;
import oracle.ifs.fdk.FileManager;
import oracle.ifs.fdk.FileManagerServiceLocator;
import oracle.ifs.fdk.GroupManager;
import oracle.ifs.fdk.GroupManagerServiceLocator;
import oracle.ifs.fdk.LockManager;
import oracle.ifs.fdk.LockManagerServiceLocator;
import oracle.ifs.fdk.NamedValue;
import oracle.ifs.fdk.RemoteLoginManager;
import oracle.ifs.fdk.RemoteLoginManagerServiceLocator;
import oracle.ifs.fdk.RequestManager;
import oracle.ifs.fdk.RequestManagerServiceLocator;
import oracle.ifs.fdk.RecordsManager;
import oracle.ifs.fdk.RecordsManagerServiceLocator;
import oracle.ifs.fdk.SearchManager;
import oracle.ifs.fdk.SearchManagerServiceLocator;
import oracle.ifs.fdk.SecurityManager;
import oracle.ifs.fdk.SecurityManagerServiceLocator;
import oracle.ifs.fdk.SessionManager;
import oracle.ifs.fdk.SessionManagerServiceLocator;
import oracle.ifs.fdk.TrashManager;
import oracle.ifs.fdk.TrashManagerServiceLocator;
import oracle.ifs.fdk.UserManager;
import oracle.ifs.fdk.UserManagerServiceLocator;
import oracle.ifs.fdk.VersionManager;
import oracle.ifs.fdk.VersionManagerServiceLocator;
import oracle.ifs.fdk.WorkflowManager;
import oracle.ifs.fdk.WorkflowManagerServiceLocator;
import oracle.ifs.fdk.WorkspaceManager;
import oracle.ifs.fdk.WorkspaceManagerServiceLocator;

import org.apache.axis.transport.http.HTTPConstants;

import org.apache.axis.client.Stub;

/**
 * Encapsulates a connection to an Oracle Content Services web services server.
 */
public class WsConnection
{
	// base server URL  
	private String m_ServerUrl;

	// session cookies
	private String[] m_SessionCookies;   
  
	// session properties
	private NamedValue[] m_Properties;

	// RemoteLoginManager
	private RemoteLoginManager m_RLM;
  
	// Other Managers
	private CategoryManager m_CAM;
	private CommonManager m_CM;
	private ContainerManager m_COM;
	private DomainManager m_DM;
	private FileManager m_FM;
	private GroupManager m_GM;
	private LockManager m_LM;
	private RecordsManager m_RM;
	private RequestManager m_RQM;
	private SearchManager m_SEM;
	private SecurityManager m_SCM;
	private SessionManager m_SM;
	private UserManager m_UM;
	private TrashManager m_TM;
	private VersionManager m_VM;
	private WorkflowManager m_WFM;
	private WorkspaceManager m_WM;
  
	/// Private Constructors
	private WsConnection(){}
  
	private WsConnection(String serverUrl)
	{
            m_ServerUrl = serverUrl;
	}
  
	/// Factory method
	/**
	 * Connects to a Oracle Content Services web services server.
	 * This is a factory method which returns an instance of this class.
	 * 
	 * @param serverUrl url spec for the server for which to connect.
	 * @param username  username as which to authenticate.
	 * @param password  user's password.
	 * @return          an instance of this class.
	 *                  
	 * @throws FdkException          if a high level error occurs.
	 * @throws MalformedURLException if the url cannot be created.
	 * @throws RemoteException       if a low-level remote error occurs.
	 * @throws ServiceException      if a low-level service error occurs.
	 */
	public static WsConnection login(String serverUrl, String username, String password) throws FdkException, MalformedURLException, RemoteException, ServiceException{
		WsConnection wsc = new WsConnection(serverUrl);
		wsc.login(username, password);
        return wsc;
	}
  
	/// Public methods
	/**
	 * Disconnects this WsConnection.
	 * 
	 * @throws FdkException    if a high level error occurs.
	 * @throws RemoteException if a low-level remote error occurs.
	 */
	public void logout() throws FdkException, RemoteException{
		m_RLM.logout();
	}
  
	/**
	 * Returns the properties for this WsConnection.
	 */
	public NamedValue[] getProperties(){
        return m_Properties;
	}
  
	/**
	 * Returns the session cookie for this WsConnection.
	 */
	public String[] getSessionCookie(){
        return m_SessionCookies;
	}
  
	/// Manager accessors
	public CategoryManager getCategoryManager() { return m_CAM; }
	public CommonManager getCommonManager() { return m_CM; }
	public ContainerManager getContainerManager() { return m_COM; }
	public DomainManager getDomainManager() { return m_DM; }
	public FileManager getFileManager() { return m_FM; }
	public GroupManager getGroupManager() { return m_GM; }
	public LockManager getLockManager() { return m_LM; }
	public RecordsManager getRecordsManager() { return m_RM; }
	public RequestManager getRequestManager() { return m_RQM; }
	public SearchManager getSearchManager() { return m_SEM; }
	public SecurityManager getSecurityManager() { return m_SCM; }
	public SessionManager getSessionManager() { return m_SM; }
	public TrashManager getTrashManager() { return m_TM; }
	public UserManager getUserManager() { return m_UM; }
	public VersionManager getVersionManager() { return m_VM; }
	public WorkflowManager getWorkflowManager() { return m_WFM; }
	public WorkspaceManager getWorkspaceManager() { return m_WM; }
  
	/// Authentication and Manager initialization
	private void login(String username, String password) throws FdkException, MalformedURLException, RemoteException, ServiceException{

		RemoteLoginManagerServiceLocator rlmsl = new RemoteLoginManagerServiceLocator();
		rlmsl.setMaintainSession(true);
    
		// initialize the RemoteLoginManager
		m_RLM = rlmsl.getRemoteLoginManager(new URL(m_ServerUrl + "/RemoteLoginManager"));
    
		// establish a session
		m_Properties = m_RLM.login(username, password, null, null);
    
		// get the cookies
		Object o = ((org.apache.axis.client.Stub)m_RLM)._getCall().getMessageContext().getProperty(HTTPConstants.HEADER_COOKIE); 
		
                if (o != null){ 
			if (o instanceof String[]){ // if multiple cookies returned .. such as when using LBR 
                            m_SessionCookies = (String[]) o; 
			}else if(o instanceof String){ 
                            m_SessionCookies = new String[1]; 
                            m_SessionCookies[0] = (String) o; 
			} 
		} 
    
		// initialize the rest of the Managers
		initializeManagers();
	}
  
	/**
	 * Initializes the web services Manager instances.
	 */
	private void initializeManagers()
    	throws RemoteException, FdkException, ServiceException, MalformedURLException
	{
		// create ServiceLocators
		CategoryManagerServiceLocator camsl = new CategoryManagerServiceLocator();
		CommonManagerServiceLocator cmsl = new CommonManagerServiceLocator();
		ContainerManagerServiceLocator comsl = new ContainerManagerServiceLocator();
		DomainManagerServiceLocator dmsl = new DomainManagerServiceLocator();
		FileManagerServiceLocator fmsl = new FileManagerServiceLocator();
		GroupManagerServiceLocator gmsl = new GroupManagerServiceLocator();
		LockManagerServiceLocator lmsl = new LockManagerServiceLocator();
		RecordsManagerServiceLocator rmsl = new RecordsManagerServiceLocator();
		RequestManagerServiceLocator rqmsl = new RequestManagerServiceLocator();
		SearchManagerServiceLocator semsl = new SearchManagerServiceLocator();
		SecurityManagerServiceLocator scmsl = new SecurityManagerServiceLocator();
		SessionManagerServiceLocator smsl = new SessionManagerServiceLocator();
		TrashManagerServiceLocator tmsl = new TrashManagerServiceLocator();
		UserManagerServiceLocator umsl = new UserManagerServiceLocator();
		VersionManagerServiceLocator vmsl = new VersionManagerServiceLocator();
		WorkflowManagerServiceLocator wfmsl = new WorkflowManagerServiceLocator();
		WorkspaceManagerServiceLocator wmsl = new WorkspaceManagerServiceLocator();
    
		// set maintain session flag
		camsl.setMaintainSession(true);
		cmsl.setMaintainSession(true);
		comsl.setMaintainSession(true);
		dmsl.setMaintainSession(true);
		fmsl.setMaintainSession(true);
		gmsl.setMaintainSession(true);
		lmsl.setMaintainSession(true);
		rmsl.setMaintainSession(true);
		rqmsl.setMaintainSession(true);
		semsl.setMaintainSession(true);
		scmsl.setMaintainSession(true);
		smsl.setMaintainSession(true);
		tmsl.setMaintainSession(true);
		umsl.setMaintainSession(true);
		vmsl.setMaintainSession(true);
		wfmsl.setMaintainSession(true);
		wmsl.setMaintainSession(true);
    
		// initialize Managers
		m_CAM = camsl.getCategoryManager(new URL(m_ServerUrl + "/CategoryManager"));
		m_CM = cmsl.getCommonManager(new URL(m_ServerUrl + "/CommonManager"));
		m_COM = comsl.getContainerManager(new URL(m_ServerUrl + "/ContainerManager"));
		m_DM = dmsl.getDomainManager(new URL(m_ServerUrl + "/DomainManager"));
		m_FM = fmsl.getFileManager(new URL(m_ServerUrl + "/FileManager"));
		m_GM = gmsl.getGroupManager(new URL(m_ServerUrl + "/GroupManager"));
		m_LM = lmsl.getLockManager(new URL(m_ServerUrl + "/LockManager"));
		m_RM = rmsl.getRecordsManager(new URL(m_ServerUrl + "/RecordsManager"));
		m_RQM = rqmsl.getRequestManager(new URL(m_ServerUrl + "/RequestManager"));
		m_SEM = semsl.getSearchManager(new URL(m_ServerUrl + "/SearchManager"));
		m_SCM = scmsl.getSecurityManager(new URL(m_ServerUrl + "/SecurityManager"));
		m_SM = smsl.getSessionManager(new URL(m_ServerUrl + "/SessionManager"));
		m_TM = tmsl.getTrashManager(new URL(m_ServerUrl + "/TrashManager"));
		m_UM = umsl.getUserManager(new URL(m_ServerUrl + "/UserManager"));
		m_VM = vmsl.getVersionManager(new URL(m_ServerUrl + "/VersionManager"));
		m_WFM = wfmsl.getWorkflowManager(new URL(m_ServerUrl + "/WorkflowManager"));
		m_WM = wmsl.getWorkspaceManager(new URL(m_ServerUrl + "/WorkspaceManager"));
    
		// maintain same session across all managers
		((Stub) m_CAM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_CM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_COM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_DM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_FM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_GM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_LM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_RM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_RQM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_SEM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_SCM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_SM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_TM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_UM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_VM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_WFM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
		((Stub) m_WM)._setProperty(HTTPConstants.HEADER_COOKIE, m_SessionCookies);
	}
}

// EOF
