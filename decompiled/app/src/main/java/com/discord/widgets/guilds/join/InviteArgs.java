package com.discord.widgets.guilds.join;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0094\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012$\u0010\u0017\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u0012\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u0012\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0010\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bHÆ\u0003ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bHÆ\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011J/\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bHÆ\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J©\u0001\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\f\b\u0002\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2&\b\u0002\u0010\u0017\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2$\b\u0002\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2$\b\u0002\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\"\u0010#R8\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b%\u0010\u0011R\u001d\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\nR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u0004R8\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b,\u0010\u0011R:\u0010\u0017\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b-\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/discord/widgets/guilds/join/InviteArgs;", "Lcom/discord/widgets/guilds/join/CaptchaArgs;", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "Ljava/lang/Class;", "component2", "()Ljava/lang/Class;", "", "component3", "()Ljava/lang/String;", "Lkotlin/Function2;", "Lcom/discord/utilities/error/Error;", "Lkotlin/coroutines/Continuation;", "", "", "component4", "()Lkotlin/jvm/functions/Function2;", "component5", "component6", "invite", "javaClass", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "onInvitePostError", "onInvitePostSuccess", "onInviteFlowFinished", "copy", "(Lcom/discord/models/domain/ModelInvite;Ljava/lang/Class;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lcom/discord/widgets/guilds/join/InviteArgs;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function2;", "getOnInviteFlowFinished", "Ljava/lang/Class;", "getJavaClass", "Ljava/lang/String;", "getLocation", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "getOnInvitePostSuccess", "getOnInvitePostError", "<init>", "(Lcom/discord/models/domain/ModelInvite;Ljava/lang/Class;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class InviteArgs extends CaptchaArgs {
    private final ModelInvite invite;
    private final Class<?> javaClass;
    private final String location;
    private final Function2<ModelInvite, Continuation<? super Unit>, Object> onInviteFlowFinished;
    private final Function2<Error, Continuation<? super Unit>, Object> onInvitePostError;
    private final Function2<ModelInvite, Continuation<? super Unit>, Object> onInvitePostSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InviteArgs(ModelInvite modelInvite, Class<?> cls, String str, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> function22, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> function23) {
        super(null);
        Intrinsics3.checkNotNullParameter(modelInvite, "invite");
        Intrinsics3.checkNotNullParameter(cls, "javaClass");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(function2, "onInvitePostError");
        Intrinsics3.checkNotNullParameter(function22, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(function23, "onInviteFlowFinished");
        this.invite = modelInvite;
        this.javaClass = cls;
        this.location = str;
        this.onInvitePostError = function2;
        this.onInvitePostSuccess = function22;
        this.onInviteFlowFinished = function23;
    }

    public static /* synthetic */ InviteArgs copy$default(InviteArgs inviteArgs, ModelInvite modelInvite, Class cls, String str, Function2 function2, Function2 function22, Function2 function23, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = inviteArgs.invite;
        }
        if ((i & 2) != 0) {
            cls = inviteArgs.javaClass;
        }
        Class cls2 = cls;
        if ((i & 4) != 0) {
            str = inviteArgs.location;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            function2 = inviteArgs.onInvitePostError;
        }
        Function2 function24 = function2;
        if ((i & 16) != 0) {
            function22 = inviteArgs.onInvitePostSuccess;
        }
        Function2 function25 = function22;
        if ((i & 32) != 0) {
            function23 = inviteArgs.onInviteFlowFinished;
        }
        return inviteArgs.copy(modelInvite, cls2, str2, function24, function25, function23);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final Class<?> component2() {
        return this.javaClass;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final Function2<Error, Continuation<? super Unit>, Object> component4() {
        return this.onInvitePostError;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> component5() {
        return this.onInvitePostSuccess;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> component6() {
        return this.onInviteFlowFinished;
    }

    public final InviteArgs copy(ModelInvite invite, Class<?> javaClass, String location, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> onInvitePostError, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(onInvitePostError, "onInvitePostError");
        Intrinsics3.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        return new InviteArgs(invite, javaClass, location, onInvitePostError, onInvitePostSuccess, onInviteFlowFinished);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteArgs)) {
            return false;
        }
        InviteArgs inviteArgs = (InviteArgs) other;
        return Intrinsics3.areEqual(this.invite, inviteArgs.invite) && Intrinsics3.areEqual(this.javaClass, inviteArgs.javaClass) && Intrinsics3.areEqual(this.location, inviteArgs.location) && Intrinsics3.areEqual(this.onInvitePostError, inviteArgs.onInvitePostError) && Intrinsics3.areEqual(this.onInvitePostSuccess, inviteArgs.onInvitePostSuccess) && Intrinsics3.areEqual(this.onInviteFlowFinished, inviteArgs.onInviteFlowFinished);
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final Class<?> getJavaClass() {
        return this.javaClass;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> getOnInviteFlowFinished() {
        return this.onInviteFlowFinished;
    }

    public final Function2<Error, Continuation<? super Unit>, Object> getOnInvitePostError() {
        return this.onInvitePostError;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> getOnInvitePostSuccess() {
        return this.onInvitePostSuccess;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        Class<?> cls = this.javaClass;
        int iHashCode2 = (iHashCode + (cls != null ? cls.hashCode() : 0)) * 31;
        String str = this.location;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Function2<Error, Continuation<? super Unit>, Object> function2 = this.onInvitePostError;
        int iHashCode4 = (iHashCode3 + (function2 != null ? function2.hashCode() : 0)) * 31;
        Function2<ModelInvite, Continuation<? super Unit>, Object> function22 = this.onInvitePostSuccess;
        int iHashCode5 = (iHashCode4 + (function22 != null ? function22.hashCode() : 0)) * 31;
        Function2<ModelInvite, Continuation<? super Unit>, Object> function23 = this.onInviteFlowFinished;
        return iHashCode5 + (function23 != null ? function23.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InviteArgs(invite=");
        sbU.append(this.invite);
        sbU.append(", javaClass=");
        sbU.append(this.javaClass);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", onInvitePostError=");
        sbU.append(this.onInvitePostError);
        sbU.append(", onInvitePostSuccess=");
        sbU.append(this.onInvitePostSuccess);
        sbU.append(", onInviteFlowFinished=");
        sbU.append(this.onInviteFlowFinished);
        sbU.append(")");
        return sbU.toString();
    }
}
