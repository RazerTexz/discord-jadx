package com.discord.widgets.tos;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action2;
import rx.functions.Func0;

/* compiled from: WidgetTos.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0017\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/tos/WidgetTos;", "Lcom/discord/app/AppFragment;", "", "configureUI", "()V", "configureCommonUI", "configureCommonTosModalUI", "configureAcknowledgementUI", "configureAgreementUI", "onViewBoundOrOnResume", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetTosBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetTosBinding;", "binding", "", "isAcknowledgement$delegate", "Lkotlin/Lazy;", "isAcknowledgement", "()Z", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetTos extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTos.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: isAcknowledgement$delegate, reason: from kotlin metadata */
    private final Lazy isAcknowledgement;

    /* compiled from: WidgetTos.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/tos/WidgetTos$Companion;", "", "Landroid/content/Context;", "context", "", "isAck", "", "show", "(Landroid/content/Context;Z)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, boolean isAck) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("intent_args_key", isAck);
            AppScreen2.d(context, WidgetTos.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTos.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTos$configureCommonTosModalUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ RestAPIParams.UserAgreements $userAgreementsParam;

        /* compiled from: WidgetTos.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.tos.WidgetTos$configureCommonTosModalUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03491 extends Lambda implements Function1<Void, Unit> {
            public static final C03491 INSTANCE = new C03491();

            public C03491() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        public AnonymousClass1(RestAPIParams.UserAgreements userAgreements) {
            this.$userAgreementsParam = userAgreements;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userAgreements(this.$userAgreementsParam), false, 1, null), WidgetTos.this, null, 2, null).k(o.a.g(WidgetTos.this.getContext(), C03491.INSTANCE, null));
            WidgetTos.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetTos.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTos$isAcknowledgement$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return WidgetTos.this.getMostRecentIntent().getBooleanExtra("intent_args_key", false);
        }
    }

    /* compiled from: WidgetTos.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTos$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetTos.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTos$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2> implements Action2<MenuItem, Context> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_settings_log_out) {
                return;
            }
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    public WidgetTos() {
        super(R.layout.widget_tos);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTos3.INSTANCE, null, 2, null);
        this.isAcknowledgement = LazyJVM.lazy(new AnonymousClass2());
    }

    private final void configureAcknowledgementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        TextView textView = binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        FormatUtils.n(textView, R.string.terms_acknowledgement_description_1, new Object[]{DateUtils.formatDateTime(requireContext(), 1648454400000L, 4)}, null, 4);
        TextView textView2 = binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        FormatUtils.n(textView2, R.string.terms_acknowledgement_description_2, new Object[0], null, 4);
    }

    private final void configureAgreementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        binding.f2674b.setOnClickListener(new WidgetTos2(this));
        TextView textView = binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        FormatUtils.n(textView, R.string.terms_agreement_description_1, new Object[0], null, 4);
        TextView textView2 = binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        FormatUtils.n(textView2, R.string.terms_agreement_description_2, new Object[0], null, 4);
        MaterialButton materialButton = binding.f2674b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "alertTosAckContinue");
        FormatUtils.n(materialButton, R.string.got_it, new Object[0], null, 4);
    }

    private final void configureCommonTosModalUI() {
        MaterialButton materialButton = getBinding().f2674b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.alertTosAckContinue");
        FormatUtils.n(materialButton, R.string.got_it, new Object[0], null, 4);
        getBinding().f2674b.setOnClickListener(new AnonymousClass1(isAcknowledgement() ? RestAPIParams.UserAgreements.INSTANCE.acknowledge() : RestAPIParams.UserAgreements.INSTANCE.agree()));
    }

    private final void configureCommonUI() {
        WidgetTosBinding binding = getBinding();
        LinkifiedTextView linkifiedTextView = binding.f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "alertTosTermsOfService");
        FormatUtils.n(linkifiedTextView, R.string.terms_of_service, new Object[]{getString(R.string.terms_of_service_url)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = binding.e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "alertTosPrivacyPolicy");
        FormatUtils.n(linkifiedTextView2, R.string.privacy_policy, new Object[]{getString(R.string.privacy_policy_url)}, null, 4);
        LinkifiedTextView linkifiedTextView3 = binding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "alertTosCommunityGuidelines");
        FormatUtils.n(linkifiedTextView3, R.string.community_guidelines, new Object[]{getString(R.string.community_guidelines_url)}, null, 4);
        LinkifiedTextView linkifiedTextView4 = binding.c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView4, "alertTosBlogPost");
        FormatUtils.n(linkifiedTextView4, R.string.blog_post, new Object[]{getString(R.string.important_updates_url)}, null, 4);
    }

    private final void configureUI() {
        configureCommonUI();
        if (isAcknowledgement()) {
            configureAcknowledgementUI();
        } else {
            configureAgreementUI();
        }
    }

    private final WidgetTosBinding getBinding() {
        return (WidgetTosBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean isAcknowledgement() {
        return ((Boolean) this.isAcknowledgement.getValue()).booleanValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, AnonymousClass1.INSTANCE, 0, 2, null);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_settings_logout, AnonymousClass2.INSTANCE, null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        configureUI();
    }
}
