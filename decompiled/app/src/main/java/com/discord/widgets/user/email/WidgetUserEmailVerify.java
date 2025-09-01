package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyResend;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.databinding.WidgetUserEmailVerifyBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailUpdate;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetUserEmailVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/user/email/WidgetUserEmailVerify;", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase;", "Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", "binding", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "emailUpdateLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserEmailVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserEmailVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> emailUpdateLauncher;

    /* compiled from: WidgetUserEmailVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "mode", "", "launch", "(Landroid/content/Context;Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            AppScreen2.d(context, WidgetUserEmailVerify.class, WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, false, true));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserEmailVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "me", "copy", "(Lcom/discord/models/user/MeUser;)Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", NotificationCompat.CATEGORY_EMAIL, "Ljava/lang/String;", "getEmail", "verified", "Z", "getVerified", "()Z", "Lcom/discord/models/user/MeUser;", "getMe", "<init>", "(Lcom/discord/models/user/MeUser;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String email;
        private final MeUser me;
        private final boolean verified;

        /* compiled from: WidgetUserEmailVerify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable<Model> observableR = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).G(WidgetUserEmailVerify2.INSTANCE).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "getUsers()\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.me = meUser;
            this.email = meUser.getEmail();
            this.verified = meUser.isVerified();
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = model.me;
            }
            return model.copy(meUser);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        public final Model copy(MeUser me2) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            return new Model(me2);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.me, ((Model) other).me);
            }
            return true;
        }

        public final String getEmail() {
            return this.email;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getVerified() {
            return this.verified;
        }

        public int hashCode() {
            MeUser meUser = this.me;
            if (meUser != null) {
                return meUser.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(me=");
            sbU.append(this.me);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUserEmailVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserEmailUpdate.Companion.launch$default(WidgetUserEmailUpdate.INSTANCE, outline.x(view, "it", "it.context"), WidgetUserEmailVerify.access$getMode$p(WidgetUserEmailVerify.this), null, 4, null);
        }
    }

    /* compiled from: WidgetUserEmailVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetUserEmailVerify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Ljava/lang/Void;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Void r1) {
                return invoke2(r1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(Void r1) {
                return new TrackNetworkActionUserVerifyResend();
            }
        }

        /* compiled from: WidgetUserEmailVerify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03512 extends Lambda implements Function1<Void, Unit> {
            public C03512() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r6) {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                WidgetUserEmailVerify widgetUserEmailVerify = WidgetUserEmailVerify.this;
                AppToast.j(widgetUserEmailVerify, FormatUtils.k(widgetUserEmailVerify, R.string.verification_email_body, new Object[]{anonymousClass2.$model.getEmail()}, null, 4), 0, 4);
            }
        }

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthVerifyResend(new RestAPIParams.EmptyBody()), false, 1, null), AnonymousClass1.INSTANCE), WidgetUserEmailVerify.this, null, 2, null), WidgetUserEmailVerify.this.getClass(), WidgetUserEmailVerify.this.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C03512(), 60, (Object) null);
        }
    }

    /* compiled from: WidgetUserEmailVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetUserEmailVerify widgetUserEmailVerify) {
            super(1, widgetUserEmailVerify, WidgetUserEmailVerify.class, "configureUI", "configureUI(Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetUserEmailVerify.access$configureUI((WidgetUserEmailVerify) this.receiver, model);
        }
    }

    public WidgetUserEmailVerify() {
        super(R.layout.widget_user_email_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserEmailVerify3.INSTANCE, null, 2, null);
        this.emailUpdateLauncher = WidgetUserEmailUpdate.INSTANCE.registerForResult(this, new WidgetUserEmailVerify4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserEmailVerify widgetUserEmailVerify, Model model) {
        widgetUserEmailVerify.configureUI(model);
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase.Mode access$getMode$p(WidgetUserEmailVerify widgetUserEmailVerify) {
        return widgetUserEmailVerify.getMode();
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserEmailVerify widgetUserEmailVerify, WidgetUserAccountVerifyBase.Mode mode) {
        widgetUserEmailVerify.setMode(mode);
    }

    private final void configureUI(Model model) {
        if (model.getVerified()) {
            requireActivity().setResult(-1);
            requireActivity().finish();
        } else if (model.getEmail() == null) {
            WidgetUserEmailUpdate.INSTANCE.launch(requireContext(), getMode(), this.emailUpdateLauncher);
        } else {
            getBinding().f2681b.setOnClickListener(new AnonymousClass1());
            getBinding().c.setOnClickListener(new AnonymousClass2(model));
        }
    }

    private final WidgetUserEmailVerifyBinding getBinding() {
        return (WidgetUserEmailVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetUserEmailVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
