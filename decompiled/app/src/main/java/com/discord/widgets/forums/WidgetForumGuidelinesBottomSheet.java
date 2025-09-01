package com.discord.widgets.forums;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetForumGuidelinesBottomSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetForumGuidelinesBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0017\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/discord/widgets/forums/WidgetForumGuidelinesBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/api/channel/Channel;", "channel", "", "configureUI", "(Lcom/discord/api/channel/Channel;)V", "", "getContentViewResId", "()I", "onResume", "()V", "", "channelId$delegate", "Lkotlin/Lazy;", "getChannelId", "()J", "channelId", "", "kotlin.jvm.PlatformType", "requestKey$delegate", "getRequestKey", "()Ljava/lang/String;", "requestKey", "guildId$delegate", "getGuildId", "guildId", "Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetForumGuidelinesBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REQUEST_KEY = "INTENT_EXTRA_REQUEST_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;

    /* compiled from: WidgetForumGuidelinesBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J?\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042 \u0010\u000b\u001a\u001c\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\b\u0012\u00060\u0007j\u0002`\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0010\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0011\u001a\u00060\u0007j\u0002`\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/forums/WidgetForumGuidelinesBottomSheet$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "requestKey", "Lkotlin/Function2;", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/ChannelId;", "", "onActionTaken", "registerForResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "guildId", "parentChannelId", "show", "(Landroidx/fragment/app/FragmentManager;JJLjava/lang/String;)V", "EXTRA_REQUEST_KEY", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function2<? super Long, ? super Long, Unit> onActionTaken) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onActionTaken, "onActionTaken");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetForumGuidelinesBottomSheet2(requestKey, onActionTaken));
        }

        public final void show(FragmentManager fragmentManager, long guildId, long parentChannelId, String requestKey) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            ForumGuidelinesManager.INSTANCE.markGuidelinesSeen(parentChannelId);
            WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet = new WidgetForumGuidelinesBottomSheet();
            widgetForumGuidelinesBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(parentChannelId)), Tuples.to(WidgetForumGuidelinesBottomSheet.EXTRA_REQUEST_KEY, requestKey)));
            widgetForumGuidelinesBottomSheet.show(fragmentManager, WidgetForumGuidelinesBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumGuidelinesBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Bundle $bundle;

        public AnonymousClass1(Bundle bundle) {
            this.$bundle = bundle;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetForumGuidelinesBottomSheet.this.dismiss();
            WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet = WidgetForumGuidelinesBottomSheet.this;
            String strAccess$getRequestKey$p = WidgetForumGuidelinesBottomSheet.access$getRequestKey$p(widgetForumGuidelinesBottomSheet);
            Intrinsics3.checkNotNullExpressionValue(strAccess$getRequestKey$p, "requestKey");
            Fragment2.setFragmentResult(widgetForumGuidelinesBottomSheet, strAccess$getRequestKey$p, this.$bundle);
        }
    }

    /* compiled from: WidgetForumGuidelinesBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetForumGuidelinesBottomSheet.access$configureUI(WidgetForumGuidelinesBottomSheet.this, channel);
        }
    }

    public WidgetForumGuidelinesBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetForumGuidelinesBottomSheet3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetForumGuidelinesBottomSheet5(this));
        this.channelId = LazyJVM.lazy(new WidgetForumGuidelinesBottomSheet4(this));
        this.requestKey = LazyJVM.lazy(new WidgetForumGuidelinesBottomSheet6(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet, Channel channel) {
        widgetForumGuidelinesBottomSheet.configureUI(channel);
    }

    public static final /* synthetic */ String access$getRequestKey$p(WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet) {
        return widgetForumGuidelinesBottomSheet.getRequestKey();
    }

    private final void configureUI(Channel channel) {
        TextView textView = getBinding().f2388b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelTopic");
        textView.setText(channel.getTopic());
        Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", getChannelId());
        bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", getGuildId());
        getBinding().c.setOnClickListener(new AnonymousClass1(bundle));
    }

    private final WidgetForumGuidelinesBottomSheetBinding getBinding() {
        return (WidgetForumGuidelinesBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_forum_guidelines_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(getChannelId()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), WidgetForumGuidelinesBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
