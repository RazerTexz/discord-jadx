package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.y.OAuthPermissionViews2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAuthorizedAppsBinding;
import com.discord.databinding.WidgetSettingsAuthorizedAppsListItemBinding;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.OAuthPermissionViews;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
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

/* compiled from: WidgetSettingsAuthorizedApps.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsAuthorizedApps;", "Lcom/discord/app/AppFragment;", "", "loadAuthorizedApps", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "", "oauthId", "deauthorizeApp", "(J)V", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/models/domain/ModelOAuth2Token;", "Lcom/discord/widgets/settings/WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder;", "adapter", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/databinding/WidgetSettingsAuthorizedAppsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsAuthorizedAppsBinding;", "binding", "<init>", "Companion", "AuthorizedAppViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAuthorizedApps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAuthorizedAppsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SimpleRecyclerAdapter<ModelOAuth2Token, AuthorizedAppViewHolder> adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsAuthorizedApps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder;", "Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "Lcom/discord/models/domain/ModelOAuth2Token;", "data", "", "bind", "(Lcom/discord/models/domain/ModelOAuth2Token;)V", "Lkotlin/Function1;", "onDeauthorizeClick", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/api/auth/OAuthScope;", "Lcom/discord/views/OAuthPermissionViews$a;", "permissionsAdapter", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/databinding/WidgetSettingsAuthorizedAppsListItemBinding;", "binding", "Lcom/discord/databinding/WidgetSettingsAuthorizedAppsListItemBinding;", "<init>", "(Lcom/discord/databinding/WidgetSettingsAuthorizedAppsListItemBinding;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AuthorizedAppViewHolder extends SimpleRecyclerAdapter.ViewHolder<ModelOAuth2Token> {
        private final WidgetSettingsAuthorizedAppsListItemBinding binding;
        private final Function1<ModelOAuth2Token, Unit> onDeauthorizeClick;
        private final SimpleRecyclerAdapter<OAuthScope, OAuthPermissionViews.a> permissionsAdapter;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public AuthorizedAppViewHolder(WidgetSettingsAuthorizedAppsListItemBinding widgetSettingsAuthorizedAppsListItemBinding, Function1<? super ModelOAuth2Token, Unit> function1) {
            Intrinsics3.checkNotNullParameter(widgetSettingsAuthorizedAppsListItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function1, "onDeauthorizeClick");
            MaterialCardView materialCardView = widgetSettingsAuthorizedAppsListItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.root");
            super(materialCardView);
            this.binding = widgetSettingsAuthorizedAppsListItemBinding;
            this.onDeauthorizeClick = function1;
            SimpleRecyclerAdapter<OAuthScope, OAuthPermissionViews.a> simpleRecyclerAdapter = new SimpleRecyclerAdapter<>(null, OAuthPermissionViews2.j, 1, null);
            this.permissionsAdapter = simpleRecyclerAdapter;
            RecyclerView recyclerView = widgetSettingsAuthorizedAppsListItemBinding.i;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.oauthApplicationPermissionsRv");
            recyclerView.setAdapter(simpleRecyclerAdapter);
            for (TextView textView : Collections2.listOf((Object[]) new TextView[]{widgetSettingsAuthorizedAppsListItemBinding.g, widgetSettingsAuthorizedAppsListItemBinding.c, widgetSettingsAuthorizedAppsListItemBinding.h})) {
                AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(textView, "header");
                accessibilityUtils.setViewIsHeading(textView);
            }
        }

        public static final /* synthetic */ Function1 access$getOnDeauthorizeClick$p(AuthorizedAppViewHolder authorizedAppViewHolder) {
            return authorizedAppViewHolder.onDeauthorizeClick;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(ModelOAuth2Token modelOAuth2Token) {
            bind2(modelOAuth2Token);
        }

        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(ModelOAuth2Token data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            Application application = data.getApplication();
            String icon = application.getIcon();
            String applicationIcon$default = icon != null ? IconUtils.getApplicationIcon$default(application.getId(), icon, 0, 4, (Object) null) : null;
            SimpleDraweeView simpleDraweeView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.oauthApplicationIconIv");
            MGImages.setImage$default(simpleDraweeView, applicationIcon$default, 0, 0, false, null, null, 124, null);
            TextView textView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthApplicationNameTv");
            textView.setText(application.getName());
            MaterialCardView materialCardView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.oauthApplicationListItem");
            materialCardView.setContentDescription(application.getName());
            TextView textView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.oauthApplicationDescriptionLabelTv");
            String description = application.getDescription();
            textView2.setVisibility((description == null || StringsJVM.isBlank(description)) ^ true ? 0 : 8);
            TextView textView3 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.oauthApplicationDescriptionTv");
            ViewExtensions.setTextAndVisibilityBy(textView3, application.getDescription());
            this.permissionsAdapter.setData(data.getScopes());
            this.binding.f2604b.setOnClickListener(new WidgetSettingsAuthorizedApps2(this, data));
        }
    }

    /* compiled from: WidgetSettingsAuthorizedApps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsAuthorizedApps$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsAuthorizedApps.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAuthorizedApps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$deauthorizeApp$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $oauthId;

        /* compiled from: WidgetSettingsAuthorizedApps.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$deauthorizeApp$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03241 extends Lambda implements Function1<Void, Unit> {
            public C03241() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
                WidgetSettingsAuthorizedApps.access$loadAuthorizedApps(WidgetSettingsAuthorizedApps.this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$oauthId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteOAuthToken(this.$oauthId), false, 1, null), WidgetSettingsAuthorizedApps.this.getContext(), "REST: deauthorize app", (Function1) null, new C03241(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: WidgetSettingsAuthorizedApps.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelOAuth2Token;", "authedTokens", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$loadAuthorizedApps$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelOAuth2Token>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelOAuth2Token> list) {
            invoke2((List<ModelOAuth2Token>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelOAuth2Token> list) {
            Intrinsics3.checkNotNullParameter(list, "authedTokens");
            WidgetSettingsAuthorizedApps.access$getAdapter$p(WidgetSettingsAuthorizedApps.this).setData(list);
        }
    }

    public WidgetSettingsAuthorizedApps() {
        super(R.layout.widget_settings_authorized_apps);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAuthorizedApps4.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetSettingsAuthorizedApps3(this), 1, null);
    }

    public static final /* synthetic */ SimpleRecyclerAdapter access$getAdapter$p(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps) {
        return widgetSettingsAuthorizedApps.adapter;
    }

    public static final /* synthetic */ void access$loadAuthorizedApps(WidgetSettingsAuthorizedApps widgetSettingsAuthorizedApps) {
        widgetSettingsAuthorizedApps.loadAuthorizedApps();
    }

    private final WidgetSettingsAuthorizedAppsBinding getBinding() {
        return (WidgetSettingsAuthorizedAppsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void loadAuthorizedApps() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getOAuthTokens(), false, 1, null), this, null, 2, null), WidgetSettingsAuthorizedApps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @MainThread
    public final void deauthorizeApp(long oauthId) {
        WidgetNoticeDialog.Builder positiveButton = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(requireContext()).setTitle(R.string.deauthorize_app).setMessage(R.string.delete_app_confirm_msg), R.string.cancel, (Function1) null, 2, (Object) null).setPositiveButton(R.string.deauthorize, new AnonymousClass1(oauthId));
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton.show(parentFragmentManager);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f2603b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.authorizedAppsList");
        recyclerView.setAdapter(this.adapter);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        loadAuthorizedApps();
    }
}
