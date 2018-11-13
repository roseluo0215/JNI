# JNI调用
1.在已经安装了ndk并配置成功的情况下新建项目。

2.新建类NativeMethod用静态代码块加载所需要的so库，并创建本地方法
static{
    System.loadLibrary("NativeMethod");// NativeMethod 为so库的名称 到时候生成的文件为 libNativeMethod.so
  }
public static native int add(int x, int y);

3.生成NativeMethod的.h头文件：在terminal中用cd命令切换当前目录为app/src/main/java下执行命令
    javah -jni com.lc.jni.NativeMethod  //生成的.h文件在src/main/java目录下
    javah -d ../jni -jni com.lc.jni.NativeMethod //生成的.h文件在src/main/jni目录下
    以上两种命令都可生成.h头文件，只不过在不同的文件夹下面。

4.生成的NativeMethod的头文件为com_lc_jni_NativeMethod.h，新建一个名叫NativeMethod的c语言文件，把.h中的文件复制到.c文件中并修改为返回两个int类型的变量相加。

5.新建Android.mk文件并配置
LOCAL_MODULE := NativeMethod 配置生成的so文件名为NativeMethod,最终会生成libNativeMethod.so
LOCAL_SRC_FILES := NativeMethod.c ,配置从哪个c文件生成so文件，如果有多个.c文件需要生成so文件用空格隔开。

6.新建Application.mk文件
APP_ABI:=all 表示生成所有类型的.so文件

7.配置以上完成后执行ndk-build 就会在src/main/路径下面生成一个libs文件夹，里面包含了 所有生成的.so文件。

8.在MainActivity中就可以调用生成的libNativeMethod.so文件中的add函数了。
