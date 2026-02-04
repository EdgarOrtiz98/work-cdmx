package com.meve.oracle.cm;

/*
 * Copyright (c) 2005, Oracle. All rights reserved.  
 */
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import java.rmi.RemoteException;

import oracle.ifs.fdk.AttributeRequest;
import oracle.ifs.fdk.FdkException;
import oracle.ifs.fdk.Item;
import oracle.ifs.fdk.NamedValue;
import oracle.ifs.fdk.NamedValueSet;

/**
 * Utility class for sample code
 */
public class WsUtility
{
  /**
   * The indentation character.
   */
  public static final String INDENT = "  ";

  public static final String NO_INDENT = "";
  
  /**
   *  Property object
   */
  public static Properties prop;

  /**
   * Prints the specified String.
   */
  public static void log(String s)
  {
    log(NO_INDENT, s);
  }

  /**
   * Prints the specified Item in a readable format.
   * 
   * @param indent indentation prefix String.
   * @param item   the Item to print.
   */
  public static void log(String indent, Item item)
  {
    if (item == null)
    {
      log(indent, "Item is null ");
      return;
    }

    log(indent, "Item [name = " + item.getName() + "]");

    NamedValue[] attributes = item.getRequestedAttributes();
    int len = (attributes == null) ? 0 : attributes.length;

    if (len > 0)
    {
      log(indent, "Requested Attributes");
    }
    for (int i = 0; i < len; i++)
    {
      log(indent + INDENT, attributes[i]);
    }
  }

  /**
   * Prints each item in the specified Item array in a readable format.
   * 
   * @param indent indentation prefix String.
   * @param items  the Item array to print.
   */
  public static void log(String indent, Item[] items)
  {
    if (items == null)
    {
      log(indent, "Item array is null");
    }
    
    log(indent, "Item array");

    int len = (items == null) ? 0 : items.length;

    for (int i = 0; i < len; i++)
    {
      log(indent + INDENT, items[i]);
    }
  }
  
  // Prints the name and value.
  // Recurses (with further indenting) if the value is an Item or NamedValue.
  private static void log(String indent, NamedValue nv)
  {
    if (nv == null)
    {
      log(indent, "Named Value is Null");
      return;
    }
    
    log(indent, "NamedValue " + "[Name = " + nv.getName() + "]");

    Object value = nv.getValue();
    
    //System.out.print(indent + "Value:");

    if (value instanceof Item)
    {
      log(indent + INDENT, (Item) value);
    }
    else if (value instanceof Item[])
    {
      log(indent + INDENT, (Item[]) value);
    }
    else if (value instanceof NamedValue)
    {
      log(indent + INDENT, (NamedValue) value);
    }
    else if (value instanceof NamedValue[])
    {
      log(indent + INDENT, (NamedValue[]) value);
    }
    else if (value instanceof NamedValueSet)
    {
      log(indent + INDENT, (NamedValueSet) value);
    }
    else if (value instanceof NamedValueSet[])
    {
      log(indent + INDENT, (NamedValueSet[]) value);
    }
    else
    {
      if (value != null)
      {
        log(indent + INDENT, value.toString());
      }
    }
  }

  // Prints all names and values in the specified NamedValue array.
  // Recurses (with further indenting) if value has other items or NamedValues.
  private static void log(String indent, NamedValue[] namedvalues)
  {
    if (namedvalues == null)
    {
      log(indent, "NamedValue Array is null");
    }

    log(indent, "NamedValueArray");

    int len = (namedvalues == null) ? 0 : namedvalues.length;

    for (int i = 0; i < len; i++)
    {
      log(indent + INDENT, namedvalues[i]);
    }
  }

  // Prints the specified NamedValueSet.
  private static void log(String indent, NamedValueSet nvset)
  {
    if (nvset == null)
    {
      log(indent, "NamedValue Set is Null");
      return;
    }
    
    log(indent, "NamedValueSet");

    NamedValue[] attributes = nvset.getNamedValues();
    int len = (attributes == null) ? 0 : attributes.length;

    for (int i = 0; i < len; i++)
    {
      log(indent + INDENT, attributes[i]);
    }
  }

  // Prints the specified NamedValueSet array.
  private static void log(String indent, NamedValueSet[] namedvaluesets)
  {
    if (namedvaluesets == null)
    {
      log(indent, "NamedValue Set Array is null");
    }
    
    log(indent, "NamedValueSetArray");

    int len = (namedvaluesets == null) ? 0 : namedvaluesets.length;

    for (int i = 0; i < len; i++)
    {
      log(indent + INDENT, namedvaluesets[i]);
    }
  }

  // Prints the specified String.
  private static void log(String indent, String s)
  {
    //System.out.println(indent + s);
  }
 
  /**
   * Creates an AttributeRequest array with a single element.
   * 
   * @param atreq the AttributeRequest to wrap in the array.
   * @return      an AttributeRequest array with a single element.
   */
  public static AttributeRequest[] newAttributeRequestArray(
    AttributeRequest atreq)
  {
    return new AttributeRequest[] { atreq };
  }

  /**
   * Creates an AttributeRequest array with a single element.
   * 
   * @param attrname the name of the Attribute for the AttributeRequest.
   * @return         an AttributeRequest array with a single element.
   */
  public static AttributeRequest[] newAttributeRequestArray(String attrname)
  {
    return newAttributeRequestArray(new String[]{attrname});
  }

  /**
   * Creates an AttributeRequest array given a set of Attribute names and/or
   * AttributeRequest instances.
   * 
   * @param attrs an array of either Attribute names (String instances)
   *              or AttributeRequest instances.
   * @return      an AttributeRequest array.
   * 
   * @throws IllegalArgumentException if either a non-String or
   *                                  non-AttributeRequest instance is included
   *                                  in any element of the attrs parameter.
   */
  public static AttributeRequest[] newAttributeRequestArray(Object[] attrs)
  {
    AttributeRequest[] attrreqs = null;
    if (attrs != null)
    {
      int len = attrs.length;
      attrreqs = new AttributeRequest[len];
      for (int i = 0; i < len; i++)
      {
        if (attrs[i] instanceof String)
        {
          attrreqs[i] = newAttributeRequest((String) attrs[i]);
        }
        else if (attrs[i] instanceof AttributeRequest)
        {
          attrreqs[i] = (AttributeRequest) attrs[i];
        }
        else
        {
          throw new IllegalArgumentException("attrs");
        }
      }
    }
    return attrreqs;
  }

  /**
   * Creates an AttributeRequest array given a set of Attribute names.
   * 
   * @param attrnames a String array of Attribute names.
   * @return          an AttributeRequest array.
   */
  public static AttributeRequest[] newAttributeRequestArray(String[] attrnames)
  {
    AttributeRequest[] attrreqs = null;
    if (attrnames != null)
    {
      int len = attrnames.length;
      attrreqs = new AttributeRequest[len];
      for (int i = 0; i < len; i++)
      {
        attrreqs[i] = newAttributeRequest(attrnames[i]);
      }
    }
    return attrreqs;
  }

  /**
   * Creates an AttributeRequest array with one element.
   * 
   * @param attrName the name of the reqested attribute.
   * @param subArs   an AttributeRequest array for the specified attribute.
   * @return         an AttributeRequest array with a single element.
   */
  public static AttributeRequest[] newAttributeRequestArray(
    String attrName, AttributeRequest[] subArs)
  {
    return new AttributeRequest[]{
      newAttributeRequest(attrName, subArs)
    };
  }

  /**
   * Creates an AttributeRequest.
   * 
   * @param attrname the name of the reqested attribute.
   * @return         a new AttributeRequest instance.
   */
  public static AttributeRequest newAttributeRequest(String attrname)
  {
    AttributeRequest ar = new AttributeRequest();
    ar.setAttributeName(attrname);
    return ar;
  }

  /**
   * Creates an AttributeRequest.
   * 
   * @param attrname the name of the reqested attribute.
   * @param subArs   an AttributeRequest array for the specified attribute.
   * @return         a new AttributeRequest instance.
   */
  public static AttributeRequest newAttributeRequest(
    String attrname, AttributeRequest[] subArs)
  {
    AttributeRequest ar = newAttributeRequest(attrname);
    ar.setRequestedAttributes(subArs);
    return ar;
  }

  /**
   * Creates a NamedValue.
   * If value is an Item, sets the value to a Long equal to the Item ID.
   * 
   * @param name  the name of the NamedValue.
   * @param value the value of the NamedValue.
   * @return      a new NamedValue instance.
   */
  public static NamedValue newNamedValue(String name, Object value)
  {
    NamedValue nv = new NamedValue();
    nv.setName(name);
    if (value instanceof Item)
    {
      nv.setValue(new Long(((Item) value).getId()));
    }
    else
    {
      nv.setValue(value);
    }
    return nv;
  }

  /**
   * Creates a NamedValue array with a single element.
   * 
   * @param name  the name of the NamedValue.
   * @param value the value of the NamedValue.
   * @return      a NamedValue array with a single element.
   */
  public static NamedValue[] newNamedValueArray(String name, Object value)
    throws FdkException, RemoteException
  {
    return newNamedValueArray(new Object[][]{{name, value}});
  }

  /**
   * Given an Object array of type {{String, Object}, ...}, creates a NamedValue
   * array.
   * 
   * If a value is an Item, sets the value to a Long equal to the Item ID.
   * 
   * @param attrs a two-dimensional array of Object
   *              of the form {{String, Object}, ...}.
   * @return      a NamedValue array.
   */
  public static NamedValue[] newNamedValueArray(Object[][] attrs)
  {
    NamedValue[] nvArray = null;
    if (attrs != null)
    {
      int rows = attrs.length;
      nvArray = new NamedValue[rows];
      for (int i = 0; i < rows; i++)
      {
        nvArray[i] = newNamedValue((String) attrs[i][0], attrs[i][1]);
      }
    }
    return nvArray;
  }

  /**
   * Creates a NamedValueSet from a single NamedValue.
   * 
   * @param nv the NamedValue to wrap with a NamedValueSet.
   * @return   a new NamedValueSet.
   */
  public static NamedValueSet newNamedValueSet(NamedValue nv)
  {
    return newNamedValueSet(new NamedValue[]{nv});
  }

  /**
   * Creates a NamedValueSet from a NamedValue array.
   * 
   * @param nvArray the NamedValue array to wrap with a NamedValueSet.
   * @return        a new NamedValueSet.
   */
  public static NamedValueSet newNamedValueSet(NamedValue[] nvArray)
  {
    NamedValueSet nvSet = new NamedValueSet();
    nvSet.setNamedValues(nvArray);
    return nvSet;
  }

  /**
   * Creates a NamedValueSet array from a single NamedValueSet.
   * 
   * @param nvSet the NamedValueSet to wrap in the array.
   * @return      a NamedValueSet array with a single element.
   */
  public static NamedValueSet[] newNamedValueSetArray(NamedValueSet nvSet)
  {
    return new NamedValueSet[]{nvSet};
  }

  /**
   * Creates a NamedValueSet array with a single element
   * from a NamedValue array.
   * 
   * @param nvArray the NamedValue array to wrap in a NamedValueSet array.
   * @return        a NamedValueSet array with a single element.
   *
   */
  public static NamedValueSet[] newNamedValueSetArray(NamedValue[] nvArray)
  {
    return newNamedValueSetArray(newNamedValueSet(nvArray));
  }
  
  /**
   * Read property file and upload into property object.
   * 
   * @param propFileName the sample code property file name
   * @return property object
   */
  public static Properties getProperty(String propFileName)
    throws IOException
  {
    FileInputStream fis = new FileInputStream(propFileName);
    prop = new Properties();
    prop.load(fis);
  
    return prop; 
  }
}

// EOF
