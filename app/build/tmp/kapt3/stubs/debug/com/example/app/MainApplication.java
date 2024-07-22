package com.example.app;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/example/app/MainApplication;", "Landroid/app/Application;", "()V", "appComponent", "error/NonExistentClass", "Lerror/NonExistentClass;", "onCreate", "", "CatchAllHandler", "app_debug"})
public final class MainApplication extends android.app.Application {
    private error.NonExistentClass appComponent;
    
    public MainApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/app/MainApplication$CatchAllHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "()V", "uncaughtException", "", "thread", "Ljava/lang/Thread;", "exception", "", "app_debug"})
    public static final class CatchAllHandler implements java.lang.Thread.UncaughtExceptionHandler {
        
        public CatchAllHandler() {
            super();
        }
        
        @java.lang.Override()
        public void uncaughtException(@org.jetbrains.annotations.NotNull()
        java.lang.Thread thread, @org.jetbrains.annotations.NotNull()
        java.lang.Throwable exception) {
        }
    }
}