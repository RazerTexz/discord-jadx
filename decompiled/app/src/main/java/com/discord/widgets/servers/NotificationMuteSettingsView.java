package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.NotificationMuteSettingsViewBinding;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationMuteSettingsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/servers/NotificationMuteSettingsView;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/servers/NotificationMuteSettingsView$ViewState;", "viewState", "Lkotlin/Function0;", "", "onMute", "onUnmute", "updateView", "(Lcom/discord/widgets/servers/NotificationMuteSettingsView$ViewState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/databinding/NotificationMuteSettingsViewBinding;", "binding", "Lcom/discord/databinding/NotificationMuteSettingsViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NotificationMuteSettingsView extends LinearLayout {
    private final NotificationMuteSettingsViewBinding binding;

    /* compiled from: NotificationMuteSettingsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u000e\u0010\u0013\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJb\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\b\b\u0002\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0003\u0010\u0017\u001a\u00020\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0010J\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b\u0012\u0010\u0004R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b#\u0010\u000bR!\u0010\u0013\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\bR\u0019\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b(\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b)\u0010\u000b¨\u0006,"}, d2 = {"Lcom/discord/widgets/servers/NotificationMuteSettingsView$ViewState;", "", "", "component1", "()Z", "", "Lcom/discord/primitives/UtcTimestamp;", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/lang/CharSequence;", "component4", "component5", "", "component6", "()I", "component7", "isMuted", "muteEndTime", "rawMuteText", "rawUnmuteText", "rawMutedStatusText", "rawMutedUntilStatusResId", "muteDescriptionText", "copy", "(ZLjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Lcom/discord/widgets/servers/NotificationMuteSettingsView$ViewState;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getRawUnmuteText", "Z", "getMuteDescriptionText", "Ljava/lang/String;", "getMuteEndTime", "I", "getRawMutedUntilStatusResId", "getRawMutedStatusText", "getRawMuteText", "<init>", "(ZLjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean isMuted;
        private final CharSequence muteDescriptionText;
        private final String muteEndTime;
        private final CharSequence rawMuteText;
        private final CharSequence rawMutedStatusText;
        private final int rawMutedUntilStatusResId;
        private final CharSequence rawUnmuteText;

        public ViewState(boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, @StringRes int i, CharSequence charSequence4) {
            Intrinsics3.checkNotNullParameter(charSequence, "rawMuteText");
            Intrinsics3.checkNotNullParameter(charSequence3, "rawMutedStatusText");
            this.isMuted = z2;
            this.muteEndTime = str;
            this.rawMuteText = charSequence;
            this.rawUnmuteText = charSequence2;
            this.rawMutedStatusText = charSequence3;
            this.rawMutedUntilStatusResId = i;
            this.muteDescriptionText = charSequence4;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = viewState.isMuted;
            }
            if ((i2 & 2) != 0) {
                str = viewState.muteEndTime;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                charSequence = viewState.rawMuteText;
            }
            CharSequence charSequence5 = charSequence;
            if ((i2 & 8) != 0) {
                charSequence2 = viewState.rawUnmuteText;
            }
            CharSequence charSequence6 = charSequence2;
            if ((i2 & 16) != 0) {
                charSequence3 = viewState.rawMutedStatusText;
            }
            CharSequence charSequence7 = charSequence3;
            if ((i2 & 32) != 0) {
                i = viewState.rawMutedUntilStatusResId;
            }
            int i3 = i;
            if ((i2 & 64) != 0) {
                charSequence4 = viewState.muteDescriptionText;
            }
            return viewState.copy(z2, str2, charSequence5, charSequence6, charSequence7, i3, charSequence4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMuteEndTime() {
            return this.muteEndTime;
        }

        /* renamed from: component3, reason: from getter */
        public final CharSequence getRawMuteText() {
            return this.rawMuteText;
        }

        /* renamed from: component4, reason: from getter */
        public final CharSequence getRawUnmuteText() {
            return this.rawUnmuteText;
        }

        /* renamed from: component5, reason: from getter */
        public final CharSequence getRawMutedStatusText() {
            return this.rawMutedStatusText;
        }

        /* renamed from: component6, reason: from getter */
        public final int getRawMutedUntilStatusResId() {
            return this.rawMutedUntilStatusResId;
        }

        /* renamed from: component7, reason: from getter */
        public final CharSequence getMuteDescriptionText() {
            return this.muteDescriptionText;
        }

        public final ViewState copy(boolean isMuted, String muteEndTime, CharSequence rawMuteText, CharSequence rawUnmuteText, CharSequence rawMutedStatusText, @StringRes int rawMutedUntilStatusResId, CharSequence muteDescriptionText) {
            Intrinsics3.checkNotNullParameter(rawMuteText, "rawMuteText");
            Intrinsics3.checkNotNullParameter(rawMutedStatusText, "rawMutedStatusText");
            return new ViewState(isMuted, muteEndTime, rawMuteText, rawUnmuteText, rawMutedStatusText, rawMutedUntilStatusResId, muteDescriptionText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isMuted == viewState.isMuted && Intrinsics3.areEqual(this.muteEndTime, viewState.muteEndTime) && Intrinsics3.areEqual(this.rawMuteText, viewState.rawMuteText) && Intrinsics3.areEqual(this.rawUnmuteText, viewState.rawUnmuteText) && Intrinsics3.areEqual(this.rawMutedStatusText, viewState.rawMutedStatusText) && this.rawMutedUntilStatusResId == viewState.rawMutedUntilStatusResId && Intrinsics3.areEqual(this.muteDescriptionText, viewState.muteDescriptionText);
        }

        public final CharSequence getMuteDescriptionText() {
            return this.muteDescriptionText;
        }

        public final String getMuteEndTime() {
            return this.muteEndTime;
        }

        public final CharSequence getRawMuteText() {
            return this.rawMuteText;
        }

        public final CharSequence getRawMutedStatusText() {
            return this.rawMutedStatusText;
        }

        public final int getRawMutedUntilStatusResId() {
            return this.rawMutedUntilStatusResId;
        }

        public final CharSequence getRawUnmuteText() {
            return this.rawUnmuteText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        public int hashCode() {
            boolean z2 = this.isMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            String str = this.muteEndTime;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            CharSequence charSequence = this.rawMuteText;
            int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            CharSequence charSequence2 = this.rawUnmuteText;
            int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            CharSequence charSequence3 = this.rawMutedStatusText;
            int iHashCode4 = (((iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31) + this.rawMutedUntilStatusResId) * 31;
            CharSequence charSequence4 = this.muteDescriptionText;
            return iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0);
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isMuted=");
            sbU.append(this.isMuted);
            sbU.append(", muteEndTime=");
            sbU.append(this.muteEndTime);
            sbU.append(", rawMuteText=");
            sbU.append(this.rawMuteText);
            sbU.append(", rawUnmuteText=");
            sbU.append(this.rawUnmuteText);
            sbU.append(", rawMutedStatusText=");
            sbU.append(this.rawMutedStatusText);
            sbU.append(", rawMutedUntilStatusResId=");
            sbU.append(this.rawMutedUntilStatusResId);
            sbU.append(", muteDescriptionText=");
            return outline.E(sbU, this.muteDescriptionText, ")");
        }

        public /* synthetic */ ViewState(boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, str, charSequence, charSequence2, charSequence3, i, (i2 & 64) != 0 ? null : charSequence4);
        }
    }

    /* compiled from: NotificationMuteSettingsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.NotificationMuteSettingsView$updateView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ boolean $isMuted;
        public final /* synthetic */ Function0 $onMute;
        public final /* synthetic */ Function0 $onUnmute;

        public AnonymousClass1(boolean z2, Function0 function0, Function0 function02) {
            this.$isMuted = z2;
            this.$onUnmute = function0;
            this.$onMute = function02;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$isMuted) {
                this.$onUnmute.invoke();
            } else {
                this.$onMute.invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationMuteSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.notification_mute_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.notification_mute_settings_mute_item;
        TextView textView = (TextView) viewInflate.findViewById(R.id.notification_mute_settings_mute_item);
        if (textView != null) {
            i = R.id.notification_mute_settings_mute_item_description;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.notification_mute_settings_mute_item_description);
            if (textView2 != null) {
                i = R.id.notification_mute_settings_mute_item_status;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.notification_mute_settings_mute_item_status);
                if (textView3 != null) {
                    NotificationMuteSettingsViewBinding notificationMuteSettingsViewBinding = new NotificationMuteSettingsViewBinding((LinearLayout) viewInflate, textView, textView2, textView3);
                    Intrinsics3.checkNotNullExpressionValue(notificationMuteSettingsViewBinding, "NotificationMuteSettings…rom(context), this, true)");
                    this.binding = notificationMuteSettingsViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void updateView(ViewState viewState, Function0<Unit> onMute, Function0<Unit> onUnmute) {
        CharSequence rawMutedStatusText;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        Intrinsics3.checkNotNullParameter(onMute, "onMute");
        Intrinsics3.checkNotNullParameter(onUnmute, "onUnmute");
        CharSequence rawMuteText = viewState.getRawMuteText();
        boolean zIsMuted = viewState.isMuted();
        String muteEndTime = viewState.getMuteEndTime();
        CharSequence muteDescriptionText = viewState.getMuteDescriptionText();
        if (zIsMuted) {
            rawMuteText = viewState.getRawUnmuteText();
        }
        TextView textView = this.binding.f2131b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.notificationMuteSettingsMuteItem");
        textView.setText(rawMuteText);
        this.binding.f2131b.setOnClickListener(new AnonymousClass1(zIsMuted, onUnmute, onMute));
        if (!zIsMuted) {
            rawMutedStatusText = "";
        } else if (muteEndTime != null) {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            rawMutedStatusText = FormatUtils.d(this, viewState.getRawMutedUntilStatusResId(), new Object[]{TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, context, null, 2, 3, 4, null)}, new NotificationMuteSettingsView2(this));
        } else {
            rawMutedStatusText = viewState.getRawMutedStatusText();
        }
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.notificationMuteSettingsMuteItemStatus");
        textView2.setText(rawMutedStatusText);
        TextView textView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.notificationMuteSettingsMuteItemStatus");
        textView3.setVisibility(zIsMuted ? 0 : 8);
        TextView textView4 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.notificationMute…ttingsMuteItemDescription");
        textView4.setVisibility(muteDescriptionText != null ? 0 : 8);
        TextView textView5 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.notificationMute…ttingsMuteItemDescription");
        textView5.setText(muteDescriptionText);
    }
}
