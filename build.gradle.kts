// Top-level build file where you can add configuration options common to all sub-projects/modules.

//buildscript {
//    dependencies {
//        repositories {
//            google()
//        }
//        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0")
//        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:")
//
//    }
//}


plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "8.1.1" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.5.1" apply false
}