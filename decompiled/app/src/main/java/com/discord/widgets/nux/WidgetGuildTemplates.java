package com.discord.widgets.nux;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetNuxGuildTemplateBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.GuildTemplatesAdapter2;
import d0.LazyJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Func0;

/* compiled from: WidgetGuildTemplates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/nux/WidgetGuildTemplates;", "Lcom/discord/app/AppFragment;", "", "fromStep", "toStep", "", "trackPostRegistrationTransition", "(Ljava/lang/String;Ljava/lang/String;)V", "trackPostRegistrationSkip", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", "binding", "Lcom/discord/widgets/nux/GuildCreateArgs;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/nux/GuildCreateArgs;", "args", "Lcom/discord/widgets/nux/GuildTemplatesAdapter;", "adapter", "Lcom/discord/widgets/nux/GuildTemplatesAdapter;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class WidgetGuildTemplates extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildTemplates.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GuildTemplatesAdapter adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/nux/WidgetGuildTemplates$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/guilds/create/CreateGuildTrigger;", "trigger", "", "isNux", "", "launch", "(Landroid/content/Context;Lcom/discord/widgets/guilds/create/CreateGuildTrigger;Z)V", "Lcom/discord/widgets/nux/GuildCreateArgs;", "args", "(Landroid/content/Context;Lcom/discord/widgets/nux/GuildCreateArgs;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, CreateGuildTrigger trigger, boolean isNux) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(trigger, "trigger");
            String str = isNux ? GuildTemplateAnalytics.STEP_GUILD_TEMPLATE : GuildTemplateAnalytics.IN_APP_LOCATION_TEMPLATE;
            String string = context.getString(R.string.guild_template_selector_title);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…_template_selector_title)");
            String string2 = context.getString(R.string.guild_template_selector_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…ate_selector_description)");
            launch(context, new WidgetGuildTemplates2(isNux, str, trigger, new WidgetGuildTemplates3(string, string2, null, false, false, 28, null), false, 16, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launch(Context context, WidgetGuildTemplates2 args) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(args, "args");
            AppScreen2.d(context, WidgetGuildTemplates.class, args);
        }
    }

    /* compiled from: WidgetGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetGuildTemplates$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetGuildTemplates.access$trackPostRegistrationSkip(WidgetGuildTemplates.this);
            return Boolean.FALSE;
        }
    }

    /* compiled from: WidgetGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetGuildTemplates$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildTemplates.access$trackPostRegistrationTransition(WidgetGuildTemplates.this, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE, GuildTemplateAnalytics.STEP_GUILD_JOIN);
            WidgetNuxPostRegistrationJoin.INSTANCE.show(WidgetGuildTemplates.this.requireContext());
            FragmentActivity activity = WidgetGuildTemplates.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public WidgetGuildTemplates() {
        super(R.layout.widget_nux_guild_template);
        this.args = LazyJVM.lazy(new WidgetGuildTemplates$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildTemplates5.INSTANCE, null, 2, null);
        this.adapter = new GuildTemplatesAdapter(new WidgetGuildTemplates4(this));
    }

    public static final /* synthetic */ WidgetGuildTemplates2 access$getArgs$p(WidgetGuildTemplates widgetGuildTemplates) {
        return widgetGuildTemplates.getArgs();
    }

    public static final /* synthetic */ void access$trackPostRegistrationSkip(WidgetGuildTemplates widgetGuildTemplates) {
        widgetGuildTemplates.trackPostRegistrationSkip();
    }

    public static final /* synthetic */ void access$trackPostRegistrationTransition(WidgetGuildTemplates widgetGuildTemplates, String str, String str2) {
        widgetGuildTemplates.trackPostRegistrationTransition(str, str2);
    }

    private final WidgetGuildTemplates2 getArgs() {
        return (WidgetGuildTemplates2) this.args.getValue();
    }

    private final WidgetNuxGuildTemplateBinding getBinding() {
        return (WidgetNuxGuildTemplateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void trackPostRegistrationSkip() {
        if (getArgs().isNux()) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationSkip$app_productionGoogleRelease(GuildTemplateAnalytics.STEP_GUILD_TEMPLATE);
        }
    }

    private final void trackPostRegistrationTransition(String fromStep, String toStep) {
        if (getArgs().isNux()) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationTransition$app_productionGoogleRelease(fromStep, toStep);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        trackPostRegistrationTransition(GuildTemplateAnalytics.STEP_REGISTRATION, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(), 0, 2, null);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.nuxGuildTemplateSectionTitle");
        textView.setText(getArgs().getGuildTemplate().getTitle());
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nuxGuildTemplateSectionCustomLabel");
        textView2.setText(getArgs().getGuildTemplate().getSubtitle());
        GuildTemplatesAdapter guildTemplatesAdapter = this.adapter;
        List<GuildTemplates> templates = getArgs().getGuildTemplate().getTemplates();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(templates, 10));
        Iterator<T> it = templates.iterator();
        while (it.hasNext()) {
            arrayList.add(new GuildTemplatesAdapter2.Template((GuildTemplates) it.next()));
        }
        guildTemplatesAdapter.setItems(arrayList);
        getBinding().f2505b.setOnClickListener(new AnonymousClass3());
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.nuxGuildTemplateSectionBottom");
        linearLayout.setVisibility(getArgs().getGuildTemplate().getShowInvitePrompt() ? 0 : 8);
    }
}
