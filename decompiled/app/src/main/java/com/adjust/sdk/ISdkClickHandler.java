package com.adjust.sdk;

/* loaded from: classes.dex */
public interface ISdkClickHandler {
    void init(IActivityHandler iActivityHandler, boolean z2);

    void pauseSending();

    void resumeSending();

    void sendReftagReferrers();

    void sendSdkClick(ActivityPackage activityPackage);

    void teardown();
}
