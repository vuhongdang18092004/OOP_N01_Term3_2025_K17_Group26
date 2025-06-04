package com.project.HospitalManager; 
public interface Selector {
  boolean end();
  Object current();
  void next();
}