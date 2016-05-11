package me.messageofdeath.WarpHome.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class YamlDatabase {
	
  private JavaPlugin plugin = null;
  private String fileName = null;
  private String fileExtension = null;
  private YamlConfiguration fileConfig = new YamlConfiguration();
  private File file = null;
  
  public YamlDatabase(JavaPlugin plugin, String fileName) {
    this.plugin = plugin;
    this.fileName = fileName;
    this.fileExtension = ".yml";
    this.fileConfig = new YamlConfiguration();
  }
  
  public void onStartUp() {
    this.file = new File(this.plugin.getDataFolder(), this.fileName + this.fileExtension);
    try {
      if (!this.file.exists()) {
        this.file.getParentFile().mkdirs();
        this.file.createNewFile();
        if (this.plugin.getResource(this.fileName + this.fileExtension) != null) {
          copy(this.plugin.getResource(this.fileName + this.fileExtension), this.file);
        }
      }
      this.fileConfig = new YamlConfiguration();
      this.fileConfig.load(this.file);
    }catch (Exception e) {
    	e.printStackTrace();
    }
  }
  
  private void copy(InputStream in, File file) {
    try {
      OutputStream out = new FileOutputStream(file);
      byte[] buf = new byte['?'];
      int len;
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }
      out.close();
      in.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void reload() {
    try {
      this.fileConfig.load(this.file);
    }catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public ConfigurationSection getConfigurationSection(String key, ConfigurationSection fallback) {
    if (this.fileConfig.contains(key)) {
      return this.fileConfig.getConfigurationSection(key);
    }
    return fallback;
  }
  
  public int getInteger(String key, int fallback) {
    if (this.fileConfig.contains(key)) {
      return this.fileConfig.getInt(key);
    }
    return fallback;
  }
  
  public String getString(String key, String fallback) {
    if (this.fileConfig.contains(key)) {
      return this.fileConfig.getString(key);
    }
    return fallback;
  }
  
  public boolean getBoolean(String key, boolean fallback) {
    if (this.fileConfig.contains(key)) {
      return this.fileConfig.getBoolean(key);
    }
    return fallback;
  }
  
  public ArrayList<String> getStringArray(String key, ArrayList<String> fallback) {
    if (this.fileConfig.contains(key)) {
      return (ArrayList<String>)this.fileConfig.getStringList(key);
    }
    return fallback;
  }
  
  public double getDouble(String key, double fallback) {
    if (this.fileConfig.contains(key)) {
      return this.fileConfig.getDouble(key);
    }
    return fallback;
  }
  
  public float getFloat(String key, float fallback) {
    if (this.fileConfig.contains(key)) {
      return (float)this.fileConfig.getDouble(key);
    }
    return fallback;
  }
  
  public void set(String key, Object set) {
    this.fileConfig.set(key, set);
    try
    {
      this.fileConfig.save(this.file);
    }catch (IOException e) {
    	e.printStackTrace();
    }
  }
}
