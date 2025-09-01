package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.d.AppHelpDesk;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.NotificationHighlightsSettingsViewBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.uri.UriHandler;
import com.discord.views.CheckedSetting;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: NotificationHighlightsSettingsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/servers/NotificationHighlightsSettingsView;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/servers/NotificationHighlightsSettingsView$ViewState;", "viewState", "Lkotlin/Function1;", "", "", "onToggled", "updateView", "(Lcom/discord/widgets/servers/NotificationHighlightsSettingsView$ViewState;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/NotificationHighlightsSettingsViewBinding;", "binding", "Lcom/discord/databinding/NotificationHighlightsSettingsViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NotificationHighlightsSettingsView extends LinearLayout {
    private final NotificationHighlightsSettingsViewBinding binding;

    /* compiled from: NotificationHighlightsSettingsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\t\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/NotificationHighlightsSettingsView$ViewState;", "", "", "component1", "()Z", "", "component2", "()I", "component3", "isMuted", "notifyHighlights", "serverTooLarge", "copy", "(ZIZ)Lcom/discord/widgets/servers/NotificationHighlightsSettingsView$ViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getServerTooLarge", "I", "getNotifyHighlights", "<init>", "(ZIZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean isMuted;
        private final int notifyHighlights;
        private final boolean serverTooLarge;

        public ViewState(boolean z2, int i, boolean z3) {
            this.isMuted = z2;
            this.notifyHighlights = i;
            this.serverTooLarge = z3;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, int i, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = viewState.isMuted;
            }
            if ((i2 & 2) != 0) {
                i = viewState.notifyHighlights;
            }
            if ((i2 & 4) != 0) {
                z3 = viewState.serverTooLarge;
            }
            return viewState.copy(z2, i, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* renamed from: component2, reason: from getter */
        public final int getNotifyHighlights() {
            return this.notifyHighlights;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getServerTooLarge() {
            return this.serverTooLarge;
        }

        public final ViewState copy(boolean isMuted, int notifyHighlights, boolean serverTooLarge) {
            return new ViewState(isMuted, notifyHighlights, serverTooLarge);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isMuted == viewState.isMuted && this.notifyHighlights == viewState.notifyHighlights && this.serverTooLarge == viewState.serverTooLarge;
        }

        public final int getNotifyHighlights() {
            return this.notifyHighlights;
        }

        public final boolean getServerTooLarge() {
            return this.serverTooLarge;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = ((r0 * 31) + this.notifyHighlights) * 31;
            boolean z3 = this.serverTooLarge;
            return i + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isMuted=");
            sbU.append(this.isMuted);
            sbU.append(", notifyHighlights=");
            sbU.append(this.notifyHighlights);
            sbU.append(", serverTooLarge=");
            return outline.O(sbU, this.serverTooLarge, ")");
        }
    }

    /* compiled from: NotificationHighlightsSettingsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.NotificationHighlightsSettingsView$updateView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ int $notifyHighlights;
        public final /* synthetic */ Function1 $onToggled;

        public AnonymousClass1(int i, Function1 function1) {
            this.$notifyHighlights = i;
            this.$onToggled = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationHighlightsSettingsView.access$getBinding$p(NotificationHighlightsSettingsView.this).c.toggle();
            int i = this.$notifyHighlights;
            int i2 = ModelNotificationSettings.HIGHLIGHTS_DISABLED;
            if (i == i2) {
                i2 = ModelNotificationSettings.HIGHLIGHTS_ENABLED;
            }
            this.$onToggled.invoke(Integer.valueOf(i2));
        }
    }

    /* compiled from: NotificationHighlightsSettingsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.NotificationHighlightsSettingsView$updateView$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.I(NotificationHighlightsSettingsView.access$getBinding$p(NotificationHighlightsSettingsView.this).f2130b, "binding.highlightsLearnMore", "binding.highlightsLearnMore.context"), AppHelpDesk.a.a(5304469213079L, null), false, false, null, 28, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationHighlightsSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.notification_highlights_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.highlights_learn_more;
        TextView textView = (TextView) viewInflate.findViewById(R.id.highlights_learn_more);
        if (textView != null) {
            i = R.id.highlights_switch;
            CheckedSetting checkedSetting = (CheckedSetting) viewInflate.findViewById(R.id.highlights_switch);
            if (checkedSetting != null) {
                i = R.id.highlights_warning;
                MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(R.id.highlights_warning);
                if (materialCardView != null) {
                    NotificationHighlightsSettingsViewBinding notificationHighlightsSettingsViewBinding = new NotificationHighlightsSettingsViewBinding((LinearLayout) viewInflate, textView, checkedSetting, materialCardView);
                    Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsViewBinding, "NotificationHighlightsSe…rom(context), this, true)");
                    this.binding = notificationHighlightsSettingsViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ NotificationHighlightsSettingsViewBinding access$getBinding$p(NotificationHighlightsSettingsView notificationHighlightsSettingsView) {
        return notificationHighlightsSettingsView.binding;
    }

    public final void updateView(ViewState viewState, Function1<? super Integer, Unit> onToggled) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        Intrinsics3.checkNotNullParameter(onToggled, "onToggled");
        boolean zIsMuted = viewState.isMuted();
        int notifyHighlights = viewState.getNotifyHighlights();
        boolean serverTooLarge = viewState.getServerTooLarge();
        this.binding.c.setLabelTagText(R.string.beta);
        this.binding.c.setLabelTagVisibility(true);
        CheckedSetting checkedSetting = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.highlightsSwitch");
        checkedSetting.setChecked((notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED || zIsMuted) ? false : true);
        if (zIsMuted) {
            CheckedSetting.d(this.binding.c, null, 1);
        } else {
            this.binding.c.e(new AnonymousClass1(notifyHighlights, onToggled));
        }
        this.binding.f2130b.setOnClickListener(new AnonymousClass2());
        MaterialCardView materialCardView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.highlightsWarning");
        materialCardView.setVisibility((!serverTooLarge || zIsMuted || notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED) ? false : true ? 0 : 8);
    }
}
