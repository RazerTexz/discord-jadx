package com.discord.models.botuikit;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.PeerConnectionFactory;

/* compiled from: ActionInteractionComponentState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/models/botuikit/ActionInteractionComponentState;", "", "<init>", "()V", "Disabled", PeerConnectionFactory.TRIAL_ENABLED, "Failed", "Loading", "Lcom/discord/models/botuikit/ActionInteractionComponentState$Enabled;", "Lcom/discord/models/botuikit/ActionInteractionComponentState$Loading;", "Lcom/discord/models/botuikit/ActionInteractionComponentState$Failed;", "Lcom/discord/models/botuikit/ActionInteractionComponentState$Disabled;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class ActionInteractionComponentState {

    /* compiled from: ActionInteractionComponentState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/models/botuikit/ActionInteractionComponentState$Disabled;", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Disabled extends ActionInteractionComponentState {
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
            super(null);
        }
    }

    /* compiled from: ActionInteractionComponentState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/models/botuikit/ActionInteractionComponentState$Enabled;", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Enabled extends ActionInteractionComponentState {
        public static final Enabled INSTANCE = new Enabled();

        private Enabled() {
            super(null);
        }
    }

    /* compiled from: ActionInteractionComponentState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/models/botuikit/ActionInteractionComponentState$Failed;", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "", "component1", "()Ljava/lang/String;", "errorMessage", "copy", "(Ljava/lang/String;)Lcom/discord/models/botuikit/ActionInteractionComponentState$Failed;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getErrorMessage", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Failed extends ActionInteractionComponentState {
        private final String errorMessage;

        public Failed(String str) {
            super(null);
            this.errorMessage = str;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.errorMessage;
            }
            return failed.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Failed copy(String errorMessage) {
            return new Failed(errorMessage);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Failed) && Intrinsics3.areEqual(this.errorMessage, ((Failed) other).errorMessage);
            }
            return true;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            String str = this.errorMessage;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("Failed(errorMessage="), this.errorMessage, ")");
        }
    }

    /* compiled from: ActionInteractionComponentState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/models/botuikit/ActionInteractionComponentState$Loading;", "Lcom/discord/models/botuikit/ActionInteractionComponentState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends ActionInteractionComponentState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private ActionInteractionComponentState() {
    }

    public /* synthetic */ ActionInteractionComponentState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
