package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelOAuth2Token.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/discord/models/domain/ModelOAuth2Token;", "", "", "component1", "()J", "", "Lcom/discord/api/auth/OAuthScope;", "component2", "()Ljava/util/List;", "Lcom/discord/api/application/Application;", "component3", "()Lcom/discord/api/application/Application;", ModelAuditLogEntry.CHANGE_KEY_ID, "scopes", "application", "copy", "(JLjava/util/List;Lcom/discord/api/application/Application;)Lcom/discord/models/domain/ModelOAuth2Token;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getScopes", "J", "getId", "Lcom/discord/api/application/Application;", "getApplication", "<init>", "(JLjava/util/List;Lcom/discord/api/application/Application;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelOAuth2Token {
    private final Application application;
    private final long id;
    private final List<OAuthScope> scopes;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelOAuth2Token(long j, List<? extends OAuthScope> list, Application application) {
        Intrinsics3.checkNotNullParameter(list, "scopes");
        Intrinsics3.checkNotNullParameter(application, "application");
        this.id = j;
        this.scopes = list;
        this.application = application;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelOAuth2Token copy$default(ModelOAuth2Token modelOAuth2Token, long j, List list, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelOAuth2Token.id;
        }
        if ((i & 2) != 0) {
            list = modelOAuth2Token.scopes;
        }
        if ((i & 4) != 0) {
            application = modelOAuth2Token.application;
        }
        return modelOAuth2Token.copy(j, list, application);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<OAuthScope> component2() {
        return this.scopes;
    }

    /* renamed from: component3, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final ModelOAuth2Token copy(long id2, List<? extends OAuthScope> scopes, Application application) {
        Intrinsics3.checkNotNullParameter(scopes, "scopes");
        Intrinsics3.checkNotNullParameter(application, "application");
        return new ModelOAuth2Token(id2, scopes, application);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelOAuth2Token)) {
            return false;
        }
        ModelOAuth2Token modelOAuth2Token = (ModelOAuth2Token) other;
        return this.id == modelOAuth2Token.id && Intrinsics3.areEqual(this.scopes, modelOAuth2Token.scopes) && Intrinsics3.areEqual(this.application, modelOAuth2Token.application);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getId() {
        return this.id;
    }

    public final List<OAuthScope> getScopes() {
        return this.scopes;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<OAuthScope> list = this.scopes;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        Application application = this.application;
        return iHashCode + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelOAuth2Token(id=");
        sbU.append(this.id);
        sbU.append(", scopes=");
        sbU.append(this.scopes);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }
}
