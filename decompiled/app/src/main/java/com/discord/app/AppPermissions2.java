package com.discord.app;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: AppPermissions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J/\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006J-\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\f\u0010\u0006J+\u0010\r\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/discord/app/AppPermissionsRequests;", "", "Lkotlin/Function0;", "", "onSuccess", "requestVideoCallPermissions", "(Lkotlin/jvm/functions/Function0;)V", "requestMedia", "onFailure", "requestMicrophone", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "requestMediaDownload", "requestCameraQRScanner", "requestContacts", "", "hasMedia", "()Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.app.AppPermissionsRequests, reason: use source file name */
/* loaded from: classes.dex */
public interface AppPermissions2 {
    public static final /* synthetic */ int a = 0;

    boolean hasMedia();

    void requestCameraQRScanner(Function0<Unit> onSuccess);

    void requestCameraQRScanner(Function0<Unit> onSuccess, Function0<Unit> onFailure);

    void requestContacts(Function0<Unit> onSuccess, Function0<Unit> onFailure);

    void requestMedia(Function0<Unit> onSuccess);

    void requestMediaDownload(Function0<Unit> onSuccess);

    void requestMicrophone(Function0<Unit> onFailure, Function0<Unit> onSuccess);

    void requestVideoCallPermissions(Function0<Unit> onSuccess);
}
