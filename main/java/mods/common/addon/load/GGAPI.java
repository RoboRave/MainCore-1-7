package mods.common.addon.load;

import java.lang.reflect.Method;

public final class GGAPI
{
  public static void addBlockIDToGrabList(int blockID)
  {
    addBlockIDToGrabList(blockID, new int[] { -1 });
  }
  
  public static void addBlockIDToGrabList(int blockID, int[] metadata)
  {
    try
    {
      Class.forName("gravigun.common.GraviGun").getMethod("addBlockIDToGrabList", new Class[] { Integer.TYPE}).invoke(null, new Object[] { Integer.valueOf(blockID), metadata });
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}