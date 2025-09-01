package com.discord.widgets.user.profile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.UserProfileAdminViewBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: UserProfileAdminView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001b\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u0006J\u001b\u0010\f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001b\u0010\u000e\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u001b\u0010\u0010\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u001b\u0010\u0012\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u001b\u0010\u0014\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileAdminView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function0;", "", "onEditMember", "setOnEditMember", "(Lkotlin/jvm/functions/Function0;)V", "onKick", "setOnKick", "onBan", "setOnBan", "onDisableCommunication", "setOnDisableCommunication", "onServerMute", "setOnServerMute", "onServerDeafen", "setOnServerDeafen", "onServerMove", "setOnServerMove", "onDisconnect", "setOnDisconnect", "Lcom/discord/widgets/user/profile/UserProfileAdminView$ViewState;", "viewState", "updateView", "(Lcom/discord/widgets/user/profile/UserProfileAdminView$ViewState;)V", "Lcom/discord/databinding/UserProfileAdminViewBinding;", "binding", "Lcom/discord/databinding/UserProfileAdminViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class UserProfileAdminView extends LinearLayout {
    private final UserProfileAdminViewBinding binding;

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0092\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b/\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b0\u0010\u0004¨\u00063"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileAdminView$ViewState;", "", "", "component1", "()Z", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "showEditMemberButton", "showKickButton", "showDisableCommunicationButton", "isMultiUserDM", "showBanButton", "showServerMuteButton", "isServerMuted", "showServerDeafenButton", "isServerDeafened", "showServerMoveAndDisconnectButtons", "isAdminSectionEnabled", "isMe", "isCommunicationDisabled", "copy", "(ZZZZZZZZZZZZZ)Lcom/discord/widgets/user/profile/UserProfileAdminView$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowEditMemberButton", "getShowBanButton", "getShowKickButton", "getShowServerMuteButton", "getShowServerMoveAndDisconnectButtons", "getShowServerDeafenButton", "getShowDisableCommunicationButton", "<init>", "(ZZZZZZZZZZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean isAdminSectionEnabled;
        private final boolean isCommunicationDisabled;
        private final boolean isMe;
        private final boolean isMultiUserDM;
        private final boolean isServerDeafened;
        private final boolean isServerMuted;
        private final boolean showBanButton;
        private final boolean showDisableCommunicationButton;
        private final boolean showEditMemberButton;
        private final boolean showKickButton;
        private final boolean showServerDeafenButton;
        private final boolean showServerMoveAndDisconnectButtons;
        private final boolean showServerMuteButton;

        public ViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
            this.showEditMemberButton = z2;
            this.showKickButton = z3;
            this.showDisableCommunicationButton = z4;
            this.isMultiUserDM = z5;
            this.showBanButton = z6;
            this.showServerMuteButton = z7;
            this.isServerMuted = z8;
            this.showServerDeafenButton = z9;
            this.isServerDeafened = z10;
            this.showServerMoveAndDisconnectButtons = z11;
            this.isAdminSectionEnabled = z12;
            this.isMe = z13;
            this.isCommunicationDisabled = z14;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.showEditMemberButton : z2, (i & 2) != 0 ? viewState.showKickButton : z3, (i & 4) != 0 ? viewState.showDisableCommunicationButton : z4, (i & 8) != 0 ? viewState.isMultiUserDM : z5, (i & 16) != 0 ? viewState.showBanButton : z6, (i & 32) != 0 ? viewState.showServerMuteButton : z7, (i & 64) != 0 ? viewState.isServerMuted : z8, (i & 128) != 0 ? viewState.showServerDeafenButton : z9, (i & 256) != 0 ? viewState.isServerDeafened : z10, (i & 512) != 0 ? viewState.showServerMoveAndDisconnectButtons : z11, (i & 1024) != 0 ? viewState.isAdminSectionEnabled : z12, (i & 2048) != 0 ? viewState.isMe : z13, (i & 4096) != 0 ? viewState.isCommunicationDisabled : z14);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowEditMemberButton() {
            return this.showEditMemberButton;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getShowServerMoveAndDisconnectButtons() {
            return this.showServerMoveAndDisconnectButtons;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsAdminSectionEnabled() {
            return this.isAdminSectionEnabled;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        /* renamed from: component13, reason: from getter */
        public final boolean getIsCommunicationDisabled() {
            return this.isCommunicationDisabled;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowKickButton() {
            return this.showKickButton;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowDisableCommunicationButton() {
            return this.showDisableCommunicationButton;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsMultiUserDM() {
            return this.isMultiUserDM;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getShowBanButton() {
            return this.showBanButton;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getShowServerMuteButton() {
            return this.showServerMuteButton;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsServerMuted() {
            return this.isServerMuted;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getShowServerDeafenButton() {
            return this.showServerDeafenButton;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsServerDeafened() {
            return this.isServerDeafened;
        }

        public final ViewState copy(boolean showEditMemberButton, boolean showKickButton, boolean showDisableCommunicationButton, boolean isMultiUserDM, boolean showBanButton, boolean showServerMuteButton, boolean isServerMuted, boolean showServerDeafenButton, boolean isServerDeafened, boolean showServerMoveAndDisconnectButtons, boolean isAdminSectionEnabled, boolean isMe, boolean isCommunicationDisabled) {
            return new ViewState(showEditMemberButton, showKickButton, showDisableCommunicationButton, isMultiUserDM, showBanButton, showServerMuteButton, isServerMuted, showServerDeafenButton, isServerDeafened, showServerMoveAndDisconnectButtons, isAdminSectionEnabled, isMe, isCommunicationDisabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.showEditMemberButton == viewState.showEditMemberButton && this.showKickButton == viewState.showKickButton && this.showDisableCommunicationButton == viewState.showDisableCommunicationButton && this.isMultiUserDM == viewState.isMultiUserDM && this.showBanButton == viewState.showBanButton && this.showServerMuteButton == viewState.showServerMuteButton && this.isServerMuted == viewState.isServerMuted && this.showServerDeafenButton == viewState.showServerDeafenButton && this.isServerDeafened == viewState.isServerDeafened && this.showServerMoveAndDisconnectButtons == viewState.showServerMoveAndDisconnectButtons && this.isAdminSectionEnabled == viewState.isAdminSectionEnabled && this.isMe == viewState.isMe && this.isCommunicationDisabled == viewState.isCommunicationDisabled;
        }

        public final boolean getShowBanButton() {
            return this.showBanButton;
        }

        public final boolean getShowDisableCommunicationButton() {
            return this.showDisableCommunicationButton;
        }

        public final boolean getShowEditMemberButton() {
            return this.showEditMemberButton;
        }

        public final boolean getShowKickButton() {
            return this.showKickButton;
        }

        public final boolean getShowServerDeafenButton() {
            return this.showServerDeafenButton;
        }

        public final boolean getShowServerMoveAndDisconnectButtons() {
            return this.showServerMoveAndDisconnectButtons;
        }

        public final boolean getShowServerMuteButton() {
            return this.showServerMuteButton;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v16, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v20, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.showEditMemberButton;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.showKickButton;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.showDisableCommunicationButton;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.isMultiUserDM;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            ?? r24 = this.showBanButton;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            ?? r25 = this.showServerMuteButton;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            ?? r26 = this.isServerMuted;
            int i12 = r26;
            if (r26 != 0) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            ?? r27 = this.showServerDeafenButton;
            int i14 = r27;
            if (r27 != 0) {
                i14 = 1;
            }
            int i15 = (i13 + i14) * 31;
            ?? r28 = this.isServerDeafened;
            int i16 = r28;
            if (r28 != 0) {
                i16 = 1;
            }
            int i17 = (i15 + i16) * 31;
            ?? r29 = this.showServerMoveAndDisconnectButtons;
            int i18 = r29;
            if (r29 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            ?? r210 = this.isAdminSectionEnabled;
            int i20 = r210;
            if (r210 != 0) {
                i20 = 1;
            }
            int i21 = (i19 + i20) * 31;
            ?? r211 = this.isMe;
            int i22 = r211;
            if (r211 != 0) {
                i22 = 1;
            }
            int i23 = (i21 + i22) * 31;
            boolean z3 = this.isCommunicationDisabled;
            return i23 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isAdminSectionEnabled() {
            return this.isAdminSectionEnabled;
        }

        public final boolean isCommunicationDisabled() {
            return this.isCommunicationDisabled;
        }

        public final boolean isMe() {
            return this.isMe;
        }

        public final boolean isMultiUserDM() {
            return this.isMultiUserDM;
        }

        public final boolean isServerDeafened() {
            return this.isServerDeafened;
        }

        public final boolean isServerMuted() {
            return this.isServerMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(showEditMemberButton=");
            sbU.append(this.showEditMemberButton);
            sbU.append(", showKickButton=");
            sbU.append(this.showKickButton);
            sbU.append(", showDisableCommunicationButton=");
            sbU.append(this.showDisableCommunicationButton);
            sbU.append(", isMultiUserDM=");
            sbU.append(this.isMultiUserDM);
            sbU.append(", showBanButton=");
            sbU.append(this.showBanButton);
            sbU.append(", showServerMuteButton=");
            sbU.append(this.showServerMuteButton);
            sbU.append(", isServerMuted=");
            sbU.append(this.isServerMuted);
            sbU.append(", showServerDeafenButton=");
            sbU.append(this.showServerDeafenButton);
            sbU.append(", isServerDeafened=");
            sbU.append(this.isServerDeafened);
            sbU.append(", showServerMoveAndDisconnectButtons=");
            sbU.append(this.showServerMoveAndDisconnectButtons);
            sbU.append(", isAdminSectionEnabled=");
            sbU.append(this.isAdminSectionEnabled);
            sbU.append(", isMe=");
            sbU.append(this.isMe);
            sbU.append(", isCommunicationDisabled=");
            return outline.O(sbU, this.isCommunicationDisabled, ")");
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnBan$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onBan;

        public AnonymousClass1(Function0 function0) {
            this.$onBan = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onBan.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnDisableCommunication$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onDisableCommunication;

        public AnonymousClass1(Function0 function0) {
            this.$onDisableCommunication = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onDisableCommunication.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnDisconnect$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onDisconnect;

        public AnonymousClass1(Function0 function0) {
            this.$onDisconnect = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onDisconnect.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnEditMember$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onEditMember;

        public AnonymousClass1(Function0 function0) {
            this.$onEditMember = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onEditMember.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnKick$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onKick;

        public AnonymousClass1(Function0 function0) {
            this.$onKick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onKick.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnServerDeafen$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onServerDeafen;

        public AnonymousClass1(Function0 function0) {
            this.$onServerDeafen = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onServerDeafen.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnServerMove$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onServerMove;

        public AnonymousClass1(Function0 function0) {
            this.$onServerMove = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onServerMove.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnServerMute$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onServerMute;

        public AnonymousClass1(Function0 function0) {
            this.$onServerMute = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onServerMute.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileAdminView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_profile_admin_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.user_profile_admin_ban;
        TextView textView = (TextView) viewInflate.findViewById(R.id.user_profile_admin_ban);
        if (textView != null) {
            i = R.id.user_profile_admin_disable_communication;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.user_profile_admin_disable_communication);
            if (textView2 != null) {
                i = R.id.user_profile_admin_edit_member;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.user_profile_admin_edit_member);
                if (textView3 != null) {
                    i = R.id.user_profile_admin_kick;
                    TextView textView4 = (TextView) viewInflate.findViewById(R.id.user_profile_admin_kick);
                    if (textView4 != null) {
                        i = R.id.user_profile_admin_server_deafen;
                        TextView textView5 = (TextView) viewInflate.findViewById(R.id.user_profile_admin_server_deafen);
                        if (textView5 != null) {
                            i = R.id.user_profile_admin_server_disconnect;
                            TextView textView6 = (TextView) viewInflate.findViewById(R.id.user_profile_admin_server_disconnect);
                            if (textView6 != null) {
                                i = R.id.user_profile_admin_server_move;
                                TextView textView7 = (TextView) viewInflate.findViewById(R.id.user_profile_admin_server_move);
                                if (textView7 != null) {
                                    i = R.id.user_profile_admin_server_mute;
                                    TextView textView8 = (TextView) viewInflate.findViewById(R.id.user_profile_admin_server_mute);
                                    if (textView8 != null) {
                                        UserProfileAdminViewBinding userProfileAdminViewBinding = new UserProfileAdminViewBinding((LinearLayout) viewInflate, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                        Intrinsics3.checkNotNullExpressionValue(userProfileAdminViewBinding, "UserProfileAdminViewBind…rom(context), this, true)");
                                        this.binding = userProfileAdminViewBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setOnBan(Function0<Unit> onBan) {
        Intrinsics3.checkNotNullParameter(onBan, "onBan");
        this.binding.f2163b.setOnClickListener(new AnonymousClass1(onBan));
    }

    public final void setOnDisableCommunication(Function0<Unit> onDisableCommunication) {
        Intrinsics3.checkNotNullParameter(onDisableCommunication, "onDisableCommunication");
        this.binding.c.setOnClickListener(new AnonymousClass1(onDisableCommunication));
    }

    public final void setOnDisconnect(Function0<Unit> onDisconnect) {
        Intrinsics3.checkNotNullParameter(onDisconnect, "onDisconnect");
        this.binding.g.setOnClickListener(new AnonymousClass1(onDisconnect));
    }

    public final void setOnEditMember(Function0<Unit> onEditMember) {
        Intrinsics3.checkNotNullParameter(onEditMember, "onEditMember");
        this.binding.d.setOnClickListener(new AnonymousClass1(onEditMember));
    }

    public final void setOnKick(Function0<Unit> onKick) {
        Intrinsics3.checkNotNullParameter(onKick, "onKick");
        this.binding.e.setOnClickListener(new AnonymousClass1(onKick));
    }

    public final void setOnServerDeafen(Function0<Unit> onServerDeafen) {
        Intrinsics3.checkNotNullParameter(onServerDeafen, "onServerDeafen");
        this.binding.f.setOnClickListener(new AnonymousClass1(onServerDeafen));
    }

    public final void setOnServerMove(Function0<Unit> onServerMove) {
        Intrinsics3.checkNotNullParameter(onServerMove, "onServerMove");
        this.binding.h.setOnClickListener(new AnonymousClass1(onServerMove));
    }

    public final void setOnServerMute(Function0<Unit> onServerMute) {
        Intrinsics3.checkNotNullParameter(onServerMute, "onServerMute");
        this.binding.i.setOnClickListener(new AnonymousClass1(onServerMute));
    }

    public final void updateView(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userProfileAdminEditMember");
        textView.setVisibility(viewState.getShowEditMemberButton() ? 0 : 8);
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.userProfileAdminKick");
        textView2.setVisibility(viewState.getShowKickButton() ? 0 : 8);
        TextView textView3 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.userProfileAdminDisableCommunication");
        textView3.setVisibility(viewState.getShowDisableCommunicationButton() ? 0 : 8);
        this.binding.e.setText(viewState.isMultiUserDM() ? R.string.remove_from_group : R.string.kick);
        TextView textView4 = this.binding.f2163b;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.userProfileAdminBan");
        textView4.setVisibility(viewState.getShowBanButton() ? 0 : 8);
        boolean zIsCommunicationDisabled = viewState.isCommunicationDisabled();
        int i = zIsCommunicationDisabled ? R.string.remove_time_out : R.string.time_out;
        Drawable drawable = zIsCommunicationDisabled ? ContextCompat.getDrawable(getContext(), R.drawable.ic_enable_guild_communication_24dp) : ContextCompat.getDrawable(getContext(), R.drawable.ic_disable_guild_communication_red_24dp);
        this.binding.c.setText(i);
        TextView textView5 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.userProfileAdminDisableCommunication");
        DrawableCompat.setCompoundDrawablesCompat$default(textView5, drawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
        TextView textView6 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.userProfileAdminServerMute");
        textView6.setVisibility(viewState.getShowServerMuteButton() ? 0 : 8);
        boolean zIsServerMuted = viewState.isServerMuted();
        boolean zIsMe = viewState.isMe();
        int themedDrawableRes$default = zIsServerMuted ? DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_mic_muted_grey, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_mic_grey, 0, 2, (Object) null);
        int i2 = zIsServerMuted ? R.string.server_unmute : R.string.server_mute;
        TextView textView7 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.userProfileAdminServerMute");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView7, themedDrawableRes$default, 0, 0, 0, 14, null);
        this.binding.i.setText(i2);
        TextView textView8 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.userProfileAdminServerDeafen");
        textView8.setVisibility(viewState.getShowServerDeafenButton() ? 0 : 8);
        boolean zIsServerDeafened = viewState.isServerDeafened();
        int themedDrawableRes$default2 = zIsServerDeafened ? DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_headset_deafened_grey, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, R.attr.ic_headset_deafened_grey, 0, 2, (Object) null);
        int i3 = zIsServerDeafened ? R.string.server_undeafen : R.string.server_deafen;
        int i4 = zIsMe ? R.string.disconnect_self : R.string.disconnect_other;
        TextView textView9 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.userProfileAdminServerDeafen");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView9, themedDrawableRes$default2, 0, 0, 0, 14, null);
        this.binding.f.setText(i3);
        TextView textView10 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.userProfileAdminServerMove");
        textView10.setVisibility(viewState.getShowServerMoveAndDisconnectButtons() ? 0 : 8);
        this.binding.g.setText(i4);
        TextView textView11 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.userProfileAdminServerDisconnect");
        textView11.setVisibility(viewState.getShowServerMoveAndDisconnectButtons() ? 0 : 8);
    }
}
