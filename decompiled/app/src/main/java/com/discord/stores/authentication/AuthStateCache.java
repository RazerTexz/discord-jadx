package com.discord.stores.authentication;

import android.content.SharedPreferences;
import b.i.a.f.e.o.f;
import com.discord.models.authentication.AuthState;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: AuthStateCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/stores/authentication/AuthStateCache;", "", "Lcom/discord/models/authentication/AuthState;", "getCachedAuthState", "()Lcom/discord/models/authentication/AuthState;", "authState", "", "cacheAuthState", "(Lcom/discord/models/authentication/AuthState;)V", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Landroid/content/SharedPreferences;", "prefs", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "Keys", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AuthStateCache {
    private final Gson gson;
    private final SharedPreferences prefs;

    /* compiled from: AuthStateCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/stores/authentication/AuthStateCache$Keys;", "", "", "AUTH_STATE", "Ljava/lang/String;", "TOKEN", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Keys {
        public static final String AUTH_STATE = "STORE_AUTH_STATE";
        public static final Keys INSTANCE = new Keys();
        public static final String TOKEN = "STORE_AUTHED_TOKEN";

        private Keys() {
        }
    }

    public AuthStateCache(SharedPreferences sharedPreferences) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.gson = new Gson();
    }

    public final void cacheAuthState(AuthState authState) throws JsonIOException {
        if (authState == null) {
            SharedPreferences.Editor editorEdit = this.prefs.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.remove(Keys.AUTH_STATE);
            editorEdit.remove(Keys.TOKEN);
            editorEdit.apply();
            return;
        }
        String strM = this.gson.m(authState);
        SharedPreferences.Editor editorEdit2 = this.prefs.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit2, "editor");
        editorEdit2.putString(Keys.AUTH_STATE, strM);
        editorEdit2.putString(Keys.TOKEN, authState.getToken());
        editorEdit2.apply();
    }

    public final AuthState getCachedAuthState() {
        String string = this.prefs.getString(Keys.AUTH_STATE, null);
        if (string != null) {
            try {
                return (AuthState) f.E1(AuthState.class).cast(this.gson.g(string, AuthState.class));
            } catch (Exception unused) {
            }
        }
        String string2 = this.prefs.getString(Keys.TOKEN, null);
        if (string2 != null) {
            return AuthState.INSTANCE.from(string2, Sets5.emptySet());
        }
        return null;
    }
}
