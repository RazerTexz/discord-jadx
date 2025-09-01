package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.HubAddServerConfirmationDialogBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubAddServerConfirmationDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u00020\u00058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubAddServerConfirmationDialog;", "Lcom/discord/app/AppDialog;", "", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/hubs/AddServerConfirmationArgs;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/hubs/AddServerConfirmationArgs;", "args", "Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubAddServerConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetHubAddServerConfirmationDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubAddServerConfirmationDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/hubs/AddServerConfirmationArgs;", "args", "Lcom/discord/widgets/hubs/WidgetHubAddServerConfirmationDialog;", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/hubs/AddServerConfirmationArgs;)Lcom/discord/widgets/hubs/WidgetHubAddServerConfirmationDialog;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final WidgetHubAddServerConfirmationDialog show(FragmentManager fragmentManager, WidgetHubAddServerConfirmationDialog2 args) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(args, "args");
            WidgetHubAddServerConfirmationDialog widgetHubAddServerConfirmationDialog = new WidgetHubAddServerConfirmationDialog();
            widgetHubAddServerConfirmationDialog.setArguments(AnimatableValueParser.e2(args));
            widgetHubAddServerConfirmationDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(WidgetHubAddServerConfirmationDialog.class).toString());
            return widgetHubAddServerConfirmationDialog;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHubAddServerConfirmationDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubAddServerConfirmationDialog.this.dismiss();
        }
    }

    public WidgetHubAddServerConfirmationDialog() {
        super(R.layout.hub_add_server_confirmation_dialog);
        this.args = LazyJVM.lazy(new WidgetHubAddServerConfirmationDialog$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubAddServerConfirmationDialog3.INSTANCE, null, 2, null);
    }

    private final WidgetHubAddServerConfirmationDialog2 getArgs() {
        return (WidgetHubAddServerConfirmationDialog2) this.args.getValue();
    }

    private final HubAddServerConfirmationDialogBinding getBinding() {
        return (HubAddServerConfirmationDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        TextView textView = getBinding().f2125b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.addServerConfirmationDialogDescription");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.a(textView, FormatUtils.h(contextRequireContext, R.string.hub_add_server_confirmation_subtitle, new Object[]{getArgs().getHubName()}, null, 4));
        getBinding().c.b();
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(getArgs().getGuildId());
        if (guild != null) {
            getBinding().c.a(IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, false, null, 28, null), guild.getShortName());
        }
    }
}
