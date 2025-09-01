package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetBanUserBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetBanUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/user/WidgetBanUser;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetBanUserBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetBanUserBinding;", "binding", "Lcom/discord/views/RadioManager;", "deleteHistoryRadioManager", "Lcom/discord/views/RadioManager;", "", "Lcom/discord/views/CheckedSetting;", "getHistoryRadios", "()Ljava/util/List;", "historyRadios", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetBanUser extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetBanUser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBanUserBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager deleteHistoryRadioManager;

    /* compiled from: WidgetBanUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/user/WidgetBanUser$Companion;", "", "", "userName", "", "guildId", "userId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "launch", "(Ljava/lang/String;JJLandroidx/fragment/app/FragmentManager;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(String userName, long guildId, long userId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(userName, "userName");
            if (fragmentManager == null) {
                return;
            }
            WidgetBanUser widgetBanUser = new WidgetBanUser();
            Bundle bundle = new Bundle();
            bundle.putString("com.discord.intent.extra.EXTRA_USER_NAME", userName);
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundle.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
            widgetBanUser.setArguments(bundle);
            widgetBanUser.show(fragmentManager, WidgetBanUser.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetBanUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBanUser.this.dismiss();
        }
    }

    /* compiled from: WidgetBanUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ String $userName;

        /* compiled from: WidgetBanUser.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r7) {
                Context context = WidgetBanUser.this.getContext();
                Context context2 = WidgetBanUser.this.getContext();
                AppToast.h(context, context2 != null ? FormatUtils.h(context2, R.string.ban_user_confirmed, new Object[]{AnonymousClass3.this.$userName}, null, 4) : null, 0, null, 12);
                WidgetBanUser.this.dismiss();
            }
        }

        public AnonymousClass3(long j, long j2, String str) {
            this.$guildId = j;
            this.$userId = j2;
            this.$userName = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            List listAccess$getHistoryRadios$p = WidgetBanUser.access$getHistoryRadios$p(WidgetBanUser.this);
            RadioManager radioManagerAccess$getDeleteHistoryRadioManager$p = WidgetBanUser.access$getDeleteHistoryRadioManager$p(WidgetBanUser.this);
            switch (((CheckedSetting) listAccess$getHistoryRadios$p.get(radioManagerAccess$getDeleteHistoryRadioManager$p != null ? radioManagerAccess$getDeleteHistoryRadioManager$p.b() : 0)).getId()) {
                case R.id.ban_user_delete_messages_1_day /* 2131362131 */:
                    i = 1;
                    break;
                case R.id.ban_user_delete_messages_7_days /* 2131362132 */:
                    i = 7;
                    break;
                case R.id.ban_user_delete_messages_none /* 2131362133 */:
                default:
                    i = 0;
                    break;
            }
            TextInputLayout textInputLayout = WidgetBanUser.access$getBinding$p(WidgetBanUser.this).h;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.banUserReason");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().banGuildMember(this.$guildId, this.$userId, new RestAPIParams.BanGuildMember(Integer.valueOf(i)), StringsJVM.isBlank(textOrEmpty) ^ true ? textOrEmpty : null), false, 1, null), WidgetBanUser.this, null, 2, null), WidgetBanUser.this.getClass(), WidgetBanUser.this.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
        }
    }

    public WidgetBanUser() {
        super(R.layout.widget_ban_user);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetBanUser3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetBanUserBinding access$getBinding$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.getBinding();
    }

    public static final /* synthetic */ RadioManager access$getDeleteHistoryRadioManager$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.deleteHistoryRadioManager;
    }

    public static final /* synthetic */ List access$getHistoryRadios$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.getHistoryRadios();
    }

    public static final /* synthetic */ void access$setDeleteHistoryRadioManager$p(WidgetBanUser widgetBanUser, RadioManager radioManager) {
        widgetBanUser.deleteHistoryRadioManager = radioManager;
    }

    private final WidgetBanUserBinding getBinding() {
        return (WidgetBanUserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getHistoryRadios() {
        CheckedSetting checkedSetting = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.banUserDeleteMessagesNone");
        CheckedSetting checkedSetting2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.banUserDeleteMessages1Day");
        CheckedSetting checkedSetting3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.banUserDeleteMessages7Days");
        return Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    public static final void launch(String str, long j, long j2, FragmentManager fragmentManager) {
        INSTANCE.launch(str, j, j2, fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.deleteHistoryRadioManager = new RadioManager(getHistoryRadios());
        for (CheckedSetting checkedSetting : getHistoryRadios()) {
            checkedSetting.e(new WidgetBanUser2(checkedSetting, this));
        }
        String string = getArgumentsOrDefault().getString("com.discord.intent.extra.EXTRA_USER_NAME", "");
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.banUserTitle");
        FormatUtils.n(textView, R.string.ban_user_title, new Object[]{string}, null, 4);
        TextView textView2 = getBinding().f2240b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.banUserBody");
        FormatUtils.n(textView2, R.string.ban_user_body, new Object[]{string}, null, 4);
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().d.setOnClickListener(new AnonymousClass3(j, j2, string));
    }
}
