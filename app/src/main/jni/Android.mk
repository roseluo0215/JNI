LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := NativeMethod

LOCAL_SRC_FILES := NativeMethod.c

include $(BUILD_SHARED_LIBRARY)

