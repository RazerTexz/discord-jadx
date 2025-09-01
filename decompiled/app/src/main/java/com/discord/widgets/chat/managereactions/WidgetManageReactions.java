package com.discord.widgets.chat.managereactions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetManageReactionsBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference0Impl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetManageReactions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/managereactions/WidgetManageReactions;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", "data", "", "configureUI", "(Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter;", "emojisAdapter", "Lcom/discord/widgets/chat/managereactions/ManageReactionsEmojisAdapter;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsModelProvider;", "modelProvider", "Lcom/discord/widgets/chat/managereactions/ManageReactionsModelProvider;", "Lcom/discord/widgets/chat/managereactions/ManageReactionsResultsAdapter;", "resultsAdapter", "Lcom/discord/widgets/chat/managereactions/ManageReactionsResultsAdapter;", "Lcom/discord/databinding/WidgetManageReactionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetManageReactionsBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetManageReactions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetManageReactions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetManageReactionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMOJI_KEY = "com.discord.intent.extra.EXTRA_EMOJI_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ManageReactionsEmojisAdapter emojisAdapter;
    private ManageReactionsModel2 modelProvider;
    private ManageReactionsResultsAdapter resultsAdapter;

    /* compiled from: WidgetManageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/chat/managereactions/WidgetManageReactions$Companion;", "", "", "channelId", "messageId", "Landroid/content/Context;", "context", "Lcom/discord/api/message/reaction/MessageReaction;", "targetedReaction", "", "create", "(JJLandroid/content/Context;Lcom/discord/api/message/reaction/MessageReaction;)V", "", "EXTRA_EMOJI_KEY", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, long j, long j2, Context context, MessageReaction messageReaction, int i, Object obj) {
            if ((i & 8) != 0) {
                messageReaction = null;
            }
            companion.create(j, j2, context, messageReaction);
        }

        public final void create(long channelId, long messageId, Context context, MessageReaction targetedReaction) {
            MessageReactionEmoji emoji;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId).putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId).putExtra(WidgetManageReactions.EXTRA_EMOJI_KEY, (targetedReaction == null || (emoji = targetedReaction.getEmoji()) == null) ? null : emoji.c());
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…eaction?.emoji?.getKey())");
            AppScreen2.d(context, WidgetManageReactions.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetManageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBound$1, reason: invalid class name */
    public final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(WidgetManageReactions widgetManageReactions) {
            super(widgetManageReactions, WidgetManageReactions.class, "modelProvider", "getModelProvider()Lcom/discord/widgets/chat/managereactions/ManageReactionsModelProvider;", 0);
        }

        @Override // d0.z.d.MutablePropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return WidgetManageReactions.access$getModelProvider$p((WidgetManageReactions) this.receiver);
        }

        @Override // d0.z.d.MutablePropertyReference0Impl
        public void set(Object obj) {
            WidgetManageReactions.access$setModelProvider$p((WidgetManageReactions) this.receiver, (ManageReactionsModel2) obj);
        }
    }

    /* compiled from: WidgetManageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(ManageReactionsModel2 manageReactionsModel2) {
            super(1, manageReactionsModel2, ManageReactionsModel2.class, "onEmojiTargeted", "onEmojiTargeted(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((ManageReactionsModel2) this.receiver).onEmojiTargeted(str);
        }
    }

    /* compiled from: WidgetManageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;", "it", "", "invoke", "(Lcom/discord/widgets/chat/managereactions/ManageReactionsModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ManageReactionsModel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ManageReactionsModel manageReactionsModel) {
            invoke2(manageReactionsModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ManageReactionsModel manageReactionsModel) {
            WidgetManageReactions.access$configureUI(WidgetManageReactions.this, manageReactionsModel);
        }
    }

    public WidgetManageReactions() {
        super(R.layout.widget_manage_reactions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetManageReactions2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetManageReactions widgetManageReactions, ManageReactionsModel manageReactionsModel) {
        widgetManageReactions.configureUI(manageReactionsModel);
    }

    public static final /* synthetic */ ManageReactionsModel2 access$getModelProvider$p(WidgetManageReactions widgetManageReactions) {
        ManageReactionsModel2 manageReactionsModel2 = widgetManageReactions.modelProvider;
        if (manageReactionsModel2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("modelProvider");
        }
        return manageReactionsModel2;
    }

    public static final /* synthetic */ void access$setModelProvider$p(WidgetManageReactions widgetManageReactions, ManageReactionsModel2 manageReactionsModel2) {
        widgetManageReactions.modelProvider = manageReactionsModel2;
    }

    private final void configureUI(ManageReactionsModel data) {
        if (data == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        manageReactionsEmojisAdapter.setData(data.getReactionItems());
        ManageReactionsResultsAdapter manageReactionsResultsAdapter = this.resultsAdapter;
        if (manageReactionsResultsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        manageReactionsResultsAdapter.setData(data.getUserItems());
    }

    public static final void create(long j, long j2, Context context, MessageReaction messageReaction) {
        INSTANCE.create(j, j2, context, messageReaction);
    }

    private final WidgetManageReactionsBinding getBinding() {
        return (WidgetManageReactionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.reactions);
        if (this.modelProvider == null) {
            this.modelProvider = new ManageReactionsModel2(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", 0L), getMostRecentIntent().getStringExtra(EXTRA_EMOJI_KEY), null, null, null, 56, null);
        }
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2482b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.manageReactionsEmojisRecycler");
        this.emojisAdapter = (ManageReactionsEmojisAdapter) companion.configure(new ManageReactionsEmojisAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.manageReactionsResultsRecycler");
        this.resultsAdapter = (ManageReactionsResultsAdapter) companion.configure(new ManageReactionsResultsAdapter(recyclerView2));
        ManageReactionsEmojisAdapter manageReactionsEmojisAdapter = this.emojisAdapter;
        if (manageReactionsEmojisAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("emojisAdapter");
        }
        ManageReactionsModel2 manageReactionsModel2 = this.modelProvider;
        if (manageReactionsModel2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("modelProvider");
        }
        manageReactionsEmojisAdapter.setOnEmojiSelectedListener(new AnonymousClass2(manageReactionsModel2));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ManageReactionsModel2 manageReactionsModel2 = this.modelProvider;
        if (manageReactionsModel2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("modelProvider");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(manageReactionsModel2.get(), this, null, 2, null), WidgetManageReactions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
