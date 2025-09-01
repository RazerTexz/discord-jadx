package com.discord.widgets.status;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatStatusBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.application.Unread;
import com.discord.stores.StoreStream;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChatStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/status/WidgetChatStatus;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/status/WidgetChatStatus$Model;", "data", "", "configureUI", "(Lcom/discord/widgets/status/WidgetChatStatus$Model;)V", "", "isEstimate", "", "count", "", "messageId", "", "getUnreadMessageText", "(ZIJ)Ljava/lang/CharSequence;", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetChatStatusBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChatStatusBinding;", "binding", "<init>", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChatStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatStatusBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetChatStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0082\b\u0018\u0000 &2\u00020\u0001:\u0001&B7\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\u0010\u0010\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010\u0011\u001a\u00060\u0005j\u0002`\t\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JJ\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\f\b\u0002\u0010\u0010\u001a\u00060\u0005j\u0002`\u00062\f\b\u0002\u0010\u0011\u001a\u00060\u0005j\u0002`\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\rJ\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0011\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\rR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\u0013\u0010\u0004R\u001d\u0010\u0010\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b#\u0010\b¨\u0006'"}, d2 = {"Lcom/discord/widgets/status/WidgetChatStatus$Model;", "", "", "component1", "()Z", "", "Lcom/discord/primitives/MessageId;", "component2", "()J", "Lcom/discord/primitives/ChannelId;", "component3", "", "component4", "()I", "component5", "unreadVisible", "unreadMessageId", "unreadChannelId", "unreadCount", "isUnreadEstimate", "copy", "(ZJJIZ)Lcom/discord/widgets/status/WidgetChatStatus$Model;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getUnreadChannelId", "I", "getUnreadCount", "Z", "getUnreadVisible", "getUnreadMessageId", "<init>", "(ZJJIZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isUnreadEstimate;
        private final long unreadChannelId;
        private final int unreadCount;
        private final long unreadMessageId;
        private final boolean unreadVisible;

        /* compiled from: WidgetChatStatus.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/status/WidgetChatStatus$Model$Companion;", "", "", "isUnreadValid", "", "", "Lcom/discord/primitives/ChannelId;", "detachedChannels", "Lcom/discord/models/application/Unread;", "unread", "Lcom/discord/widgets/status/WidgetChatStatus$Model;", "createModel", "(ZLjava/util/Set;Lcom/discord/models/application/Unread;)Lcom/discord/widgets/status/WidgetChatStatus$Model;", "Lrx/Observable;", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ Model access$createModel(Companion companion, boolean z2, Set set, Unread unread) {
                return companion.createModel(z2, set, unread);
            }

            private final Model createModel(boolean isUnreadValid, Set<Long> detachedChannels, Unread unread) {
                Unread.Marker marker = unread.getMarker();
                boolean zContains = detachedChannels.contains(Long.valueOf(marker.getChannelId()));
                int count = unread.getCount();
                int i = zContains ? 25 : 50;
                boolean z2 = isUnreadValid && unread.getCount() > 0 && marker.getChannelId() > 0;
                long channelId = marker.getChannelId();
                Long messageId = marker.getMessageId();
                return new Model(z2, messageId != null ? messageId.longValue() : 0L, channelId, _Ranges.coerceIn(count, 0, i), count >= i);
            }

            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(companion.getChannelsSelected().observeId().r().Y(WidgetChatStatus3.INSTANCE).r(), companion.getMessages().getAllDetached(), companion.getReadStates().getUnreadMarkerForSelectedChannel(), new WidgetChatStatus7(new WidgetChatStatus2(this)), 500L, TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…ILLISECONDS\n            )");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableCombineLatest).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(boolean z2, long j, long j2, int i, boolean z3) {
            this.unreadVisible = z2;
            this.unreadMessageId = j;
            this.unreadChannelId = j2;
            this.unreadCount = i;
            this.isUnreadEstimate = z3;
        }

        public static /* synthetic */ Model copy$default(Model model, boolean z2, long j, long j2, int i, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = model.unreadVisible;
            }
            if ((i2 & 2) != 0) {
                j = model.unreadMessageId;
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = model.unreadChannelId;
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = model.unreadCount;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                z3 = model.isUnreadEstimate;
            }
            return model.copy(z2, j3, j4, i3, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getUnreadVisible() {
            return this.unreadVisible;
        }

        /* renamed from: component2, reason: from getter */
        public final long getUnreadMessageId() {
            return this.unreadMessageId;
        }

        /* renamed from: component3, reason: from getter */
        public final long getUnreadChannelId() {
            return this.unreadChannelId;
        }

        /* renamed from: component4, reason: from getter */
        public final int getUnreadCount() {
            return this.unreadCount;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsUnreadEstimate() {
            return this.isUnreadEstimate;
        }

        public final Model copy(boolean unreadVisible, long unreadMessageId, long unreadChannelId, int unreadCount, boolean isUnreadEstimate) {
            return new Model(unreadVisible, unreadMessageId, unreadChannelId, unreadCount, isUnreadEstimate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.unreadVisible == model.unreadVisible && this.unreadMessageId == model.unreadMessageId && this.unreadChannelId == model.unreadChannelId && this.unreadCount == model.unreadCount && this.isUnreadEstimate == model.isUnreadEstimate;
        }

        public final long getUnreadChannelId() {
            return this.unreadChannelId;
        }

        public final int getUnreadCount() {
            return this.unreadCount;
        }

        public final long getUnreadMessageId() {
            return this.unreadMessageId;
        }

        public final boolean getUnreadVisible() {
            return this.unreadVisible;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z2 = this.unreadVisible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int iA = (((b.a(this.unreadChannelId) + ((b.a(this.unreadMessageId) + (r0 * 31)) * 31)) * 31) + this.unreadCount) * 31;
            boolean z3 = this.isUnreadEstimate;
            return iA + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isUnreadEstimate() {
            return this.isUnreadEstimate;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(unreadVisible=");
            sbU.append(this.unreadVisible);
            sbU.append(", unreadMessageId=");
            sbU.append(this.unreadMessageId);
            sbU.append(", unreadChannelId=");
            sbU.append(this.unreadChannelId);
            sbU.append(", unreadCount=");
            sbU.append(this.unreadCount);
            sbU.append(", isUnreadEstimate=");
            return outline.O(sbU, this.isUnreadEstimate, ")");
        }
    }

    /* compiled from: WidgetChatStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetChatStatus$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(this.$data.getUnreadChannelId(), this.$data.getUnreadMessageId());
        }
    }

    /* compiled from: WidgetChatStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetChatStatus$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass2(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getReadStates().markAsRead(Long.valueOf(this.$data.getUnreadChannelId()));
        }
    }

    /* compiled from: WidgetChatStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetChatStatus$Model;", "it", "", "invoke", "(Lcom/discord/widgets/status/WidgetChatStatus$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetChatStatus$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetChatStatus.access$configureUI(WidgetChatStatus.this, model);
        }
    }

    public WidgetChatStatus() {
        super(R.layout.widget_chat_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChatStatus6.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatStatus widgetChatStatus, Model model) {
        widgetChatStatus.configureUI(model);
    }

    @MainThread
    private final void configureUI(Model data) {
        LinearLayout linearLayout = getBinding().f2346b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatStatusUnreadMessages");
        linearLayout.setVisibility(data.getUnreadVisible() ? 0 : 8);
        getBinding().f2346b.setOnClickListener(new AnonymousClass1(data));
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatStatusUnreadMessagesText");
        textView.setText(getUnreadMessageText(data.isUnreadEstimate(), data.getUnreadCount(), data.getUnreadMessageId()));
        getBinding().c.setOnClickListener(new AnonymousClass2(data));
    }

    private final WidgetChatStatusBinding getBinding() {
        return (WidgetChatStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getUnreadMessageText(boolean isEstimate, int count, long messageId) throws Resources.NotFoundException {
        String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, TimeUtils.parseSnowflake(Long.valueOf(messageId)), requireContext(), 0, 4, null);
        if (isEstimate) {
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            return FormatUtils.c(resources, R.string.new_messages_estimated, new Object[0], new AnonymousClass1(count, strRenderUtcDate$default));
        }
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources2, requireContext(), R.plurals.new_messages_count, count, Integer.valueOf(count));
        Resources resources3 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
        return FormatUtils.c(resources3, R.string.new_messages, new Object[0], new AnonymousClass2(quantityString, strRenderUtcDate$default));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetChatStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    /* compiled from: WidgetChatStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetChatStatus$getUnreadMessageText$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ int $count;
        public final /* synthetic */ String $utcDateTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, String str) {
            super(1);
            this.$count = i;
            this.$utcDateTime = str;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("count", String.valueOf(this.$count));
            renderContext.args.put("timestamp", this.$utcDateTime);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetChatStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetChatStatus$getUnreadMessageText$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CharSequence $countPlural;
        public final /* synthetic */ String $utcDateTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CharSequence charSequence, String str) {
            super(1);
            this.$countPlural = charSequence;
            this.$utcDateTime = str;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("count", this.$countPlural.toString());
            renderContext.args.put("timestamp", this.$utcDateTime);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
