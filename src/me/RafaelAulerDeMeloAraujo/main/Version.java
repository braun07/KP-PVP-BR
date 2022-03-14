package me.RafaelAulerDeMeloAraujo.main;


import org.bukkit.Bukkit;


public enum Version
{
  v1_17(17),  v1_16_4(16),  v1_16_3(16),  v1_16_2(16),  v1_16(16),  v1_15(15),  v1_14(14),  v1_13(13),  v1_12(12),  v1_11(11),  v1_10(10),  v1_9(9),  v1_8(8),  v1_7(7),  v1_6(6),  v1_5(5),  DESCONHECIDA(999);
  
  public int value;
  
  public static Version getServerVersion()
  {
    Version version = getServerVersion(getMinecraftVersion());
    if (version == DESCONHECIDA) {
      version = getServerVersion(Bukkit.getVersion());
    }
    return version;
  }
  public static String getMinecraftVersion()
  {
    try
    {
      String info = Bukkit.getVersion();
      return info.split("MC: ")[1].split("\\)")[0];
    }
    catch (Throwable e) {}
    return "Desconhecida";
  }
  
  private static Version getServerVersion(String ver)
  {
    if (ver.contains("1.17")) {
      return v1_17;
    }
    if (ver.contains("1.16.4")) {
      return v1_16_4;
    }
    if (ver.contains("1.16.3")) {
      return v1_16_3;
    }
    if (ver.contains("1.16.2")) {
      return v1_16_2;
    }
    if (ver.contains("1.16")) {
      return v1_16;
    }
    if (ver.contains("1.15")) {
      return v1_15;
    }
    if (ver.contains("1.14")) {
      return v1_14;
    }
    if (ver.contains("1.13")) {
      return v1_13;
    }
    if (ver.contains("1.12")) {
      return v1_12;
    }
    if (ver.contains("1.11")) {
      return v1_11;
    }
    if (ver.contains("1.10")) {
      return v1_10;
    }
    if (ver.contains("1.9")) {
      return v1_9;
    }
    if (ver.contains("1.8")) {
      return v1_8;
    }
    if (ver.contains("1.7")) {
      return v1_7;
    }
    if (ver.contains("1.6")) {
      return v1_6;
    }
    if (ver.contains("1.5")) {
      return v1_5;
    }
    return DESCONHECIDA;
  }
  
  private Version(int value)
  {
    this.value = value;
  }
}

