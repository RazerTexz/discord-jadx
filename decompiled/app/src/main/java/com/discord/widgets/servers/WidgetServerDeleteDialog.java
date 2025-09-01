package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetNavigator;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/* compiled from: WidgetServerDeleteDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\fJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00032\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerDeleteDialog;", "Lcom/discord/app/AppDialog;", "Lcom/discord/widgets/servers/WidgetServerDeleteDialog$Model;", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerDeleteDialog$Model;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "afterDeleteGuild", "(J)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", "binding", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerDeleteDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerDeleteDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_GUILD_ID = "INTENT_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetServerDeleteDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerDeleteDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "show", "(Landroidx/fragment/app/FragmentManager;J)V", "", WidgetServerDeleteDialog.INTENT_GUILD_ID, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetServerDeleteDialog widgetServerDeleteDialog = new WidgetServerDeleteDialog();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetServerDeleteDialog.INTENT_GUILD_ID, guildId);
            widgetServerDeleteDialog.setArguments(bundle);
            widgetServerDeleteDialog.show(fragmentManager, WidgetServerDeleteDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerDeleteDialog$Model;", "", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/guild/Guild;", "getGuild", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/models/user/MeUser;", "getMe", "()Lcom/discord/models/user/MeUser;", "<init>", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final MeUser me;

        /* compiled from: WidgetServerDeleteDialog.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\n\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerDeleteDialog$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerDeleteDialog$Model;", "kotlin.jvm.PlatformType", "get$app_productionGoogleRelease", "(J)Lrx/Observable;", "get", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get$app_productionGoogleRelease(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(guildId);
                WidgetServerDeleteDialog2 widgetServerDeleteDialog2 = WidgetServerDeleteDialog2.INSTANCE;
                Object widgetServerDeleteDialog4 = widgetServerDeleteDialog2;
                if (widgetServerDeleteDialog2 != null) {
                    widgetServerDeleteDialog4 = new WidgetServerDeleteDialog4(widgetServerDeleteDialog2);
                }
                Observable observableJ = Observable.j(observableObserveMe$default, observableObserveGuild, (Func2) widgetServerDeleteDialog4);
                Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…      ::Model\n          )");
                return ObservableExtensionsKt.computationLatest(observableJ).r();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.me = meUser;
            this.guild = guild;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final MeUser getMe() {
            return this.me;
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerDeleteDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        /* compiled from: WidgetServerDeleteDialog.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<Void> {
            public AnonymousClass1() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) {
                call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r4) {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                WidgetServerDeleteDialog.access$afterDeleteGuild(WidgetServerDeleteDialog.this, anonymousClass2.$this_configureUI.getGuild().getId());
            }
        }

        public AnonymousClass2(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            long id2 = this.$this_configureUI.getGuild().getId();
            TextInputLayout textInputLayout = WidgetServerDeleteDialog.access$getBinding$p(WidgetServerDeleteDialog.this).e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsDeleteServerMfaCode");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.deleteGuild(id2, new RestAPIParams.DeleteGuild(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), WidgetServerDeleteDialog.this, null, 2, null).k(o.j(new AnonymousClass1(), WidgetServerDeleteDialog.this.getContext(), null, 4));
        }
    }

    /* compiled from: WidgetServerDeleteDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerDeleteDialog$Model;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerDeleteDialog$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetServerDeleteDialog widgetServerDeleteDialog = WidgetServerDeleteDialog.this;
            Intrinsics3.checkNotNullExpressionValue(model, "it");
            WidgetServerDeleteDialog.access$configureUI(widgetServerDeleteDialog, model);
        }
    }

    public WidgetServerDeleteDialog() {
        super(R.layout.widget_server_delete_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerDeleteDialog3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$afterDeleteGuild(WidgetServerDeleteDialog widgetServerDeleteDialog, long j) {
        widgetServerDeleteDialog.afterDeleteGuild(j);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerDeleteDialog widgetServerDeleteDialog, Model model) {
        widgetServerDeleteDialog.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerDeleteDialogBinding access$getBinding$p(WidgetServerDeleteDialog widgetServerDeleteDialog) {
        return widgetServerDeleteDialog.getBinding();
    }

    private final void afterDeleteGuild(long guildId) {
        dismiss();
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2020-12_guild_delete_feedback", true);
        if (userExperiment == null || userExperiment.getBucket() != 1) {
            return;
        }
        GuildDeleteFeedbackSheetNavigator.INSTANCE.enqueueNotice(guildId);
    }

    private final void configureUI(Model model) {
        if (model.getGuild() == null) {
            dismiss();
            return;
        }
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsDeleteServerHeader");
        Context context = getContext();
        textView.setText(context != null ? FormatUtils.h(context, R.string.delete_server_title, new Object[]{model.getGuild().getName()}, null, 4) : null);
        LinearLayout linearLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsDeleteServerMfaWrap");
        linearLayout.setVisibility(model.getMe().getMfaEnabled() ? 0 : 8);
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsDeleteServerText");
        FormatUtils.n(textView2, R.string.delete_server_body, new Object[]{model.getGuild().getName()}, null, 4);
        getBinding().f2536b.setOnClickListener(new AnonymousClass1());
        MaterialButton materialButton = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsDeleteServerConfirm");
        materialButton.setEnabled(model.getGuild().isOwner(model.getMe().getId()));
        getBinding().c.setOnClickListener(new AnonymousClass2(model));
    }

    private final WidgetServerDeleteDialogBinding getBinding() {
        return (WidgetServerDeleteDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observable = Model.INSTANCE.get$app_productionGoogleRelease(getArgumentsOrDefault().getLong(INTENT_GUILD_ID));
        Intrinsics3.checkNotNullExpressionValue(observable, "Model.get(guildId)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetServerDeleteDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
