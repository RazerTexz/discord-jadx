package com.adjust.sdk;

/* loaded from: classes.dex */
public interface IRequestHandler {
    void init(IActivityHandler iActivityHandler, IPackageHandler iPackageHandler);

    void sendPackage(ActivityPackage activityPackage, int i);

    void teardown();
}
