#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_sydauto_ndk_manager_SydManager_getJniMessage(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
