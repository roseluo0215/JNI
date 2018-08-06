package com.lc.jni;

/**
 * Created by luocheng on 18/8/6.
 */

public class NativeMethod {

  static{
    System.loadLibrary("NativeMethod");
  }
  public static native int add(int x, int y);
}
