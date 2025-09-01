package b.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.a.GuildBoostUncancelViewModel3;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.GuildBoostUncancelDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: GuildBoostUncancelDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0015\u001a\u00060\u000fj\u0002`\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lb/a/a/a/a;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lb/a/i/u;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/u;", "binding", "", "Lcom/discord/primitives/GuildBoostSlotId;", "n", "Lkotlin/Lazy;", "getSlotId", "()J", "slotId", "Lb/a/a/a/k;", "m", "getViewModel", "()Lb/a/a/a/k;", "viewModel", "<init>", "k", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.a.a, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostUncancelDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(GuildBoostUncancelDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUncancelDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* renamed from: n, reason: from kotlin metadata */
    public final Lazy slotId;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.a.a$a */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                GuildBoostUncancelViewModel3 guildBoostUncancelViewModel3 = (GuildBoostUncancelViewModel3) ((GuildBoostUncancelDialog) this.k).viewModel.getValue();
                GuildBoostUncancelViewModel3.c viewState = guildBoostUncancelViewModel3.getViewState();
                if (Intrinsics3.areEqual(viewState, GuildBoostUncancelViewModel3.c.C0009c.a)) {
                    return;
                }
                if ((viewState instanceof GuildBoostUncancelViewModel3.c.b) || (viewState instanceof GuildBoostUncancelViewModel3.c.a)) {
                    guildBoostUncancelViewModel3.updateViewState(new GuildBoostUncancelViewModel3.c.a(null, 1));
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            GuildBoostUncancelViewModel3 guildBoostUncancelViewModel32 = (GuildBoostUncancelViewModel3) ((GuildBoostUncancelDialog) this.k).viewModel.getValue();
            GuildBoostUncancelViewModel3.c viewState2 = guildBoostUncancelViewModel32.getViewState();
            if (Intrinsics3.areEqual(viewState2, GuildBoostUncancelViewModel3.c.C0009c.a)) {
                return;
            }
            if (!(viewState2 instanceof GuildBoostUncancelViewModel3.c.b)) {
                if ((viewState2 instanceof GuildBoostUncancelViewModel3.c.d) || (viewState2 instanceof GuildBoostUncancelViewModel3.c.a)) {
                    guildBoostUncancelViewModel32.updateViewState(new GuildBoostUncancelViewModel3.c.a(null, 1));
                    return;
                }
                return;
            }
            GuildBoostUncancelViewModel3.c viewState3 = guildBoostUncancelViewModel32.getViewState();
            Objects.requireNonNull(viewState3, "null cannot be cast to non-null type com.discord.dialogs.guildboost.GuildBoostUncancelViewModel.ViewState.Loaded");
            if (((GuildBoostUncancelViewModel3.c.b) viewState3).f43b) {
                return;
            }
            GuildBoostUncancelViewModel3.c viewState4 = guildBoostUncancelViewModel32.getViewState();
            if (!(viewState4 instanceof GuildBoostUncancelViewModel3.c.b)) {
                viewState4 = null;
            }
            GuildBoostUncancelViewModel3.c.b bVar = (GuildBoostUncancelViewModel3.c.b) viewState4;
            if (bVar != null) {
                guildBoostUncancelViewModel32.updateViewState(GuildBoostUncancelViewModel3.c.b.a(bVar, null, true, false, 5));
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.uncancelGuildBoostSlot(guildBoostUncancelViewModel32.n, guildBoostUncancelViewModel32.k, bVar.a, guildBoostUncancelViewModel32.m), guildBoostUncancelViewModel32, null, 2, null), GuildBoostUncancelViewModel3.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildBoostUncancelViewModel4(guildBoostUncancelViewModel32, bVar), 62, (Object) null);
            }
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    /* renamed from: b.a.a.a.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    /* renamed from: b.a.a.a.a$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, GuildBoostUncancelDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, GuildBoostUncancelDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUncancelDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildBoostUncancelDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.guild_boost_uncancel_body;
            TextView textView = (TextView) view2.findViewById(R.id.guild_boost_uncancel_body);
            if (textView != null) {
                i = R.id.guild_boost_uncancel_confirm;
                LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.guild_boost_uncancel_confirm);
                if (loadingButton != null) {
                    i = R.id.guild_boost_uncancel_error;
                    TextView textView2 = (TextView) view2.findViewById(R.id.guild_boost_uncancel_error);
                    if (textView2 != null) {
                        i = R.id.guild_boost_uncancel_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R.id.guild_boost_uncancel_flipper);
                        if (appViewFlipper != null) {
                            i = R.id.guild_boost_uncancel_header;
                            TextView textView3 = (TextView) view2.findViewById(R.id.guild_boost_uncancel_header);
                            if (textView3 != null) {
                                i = R.id.guild_boost_uncancel_image;
                                ImageView imageView = (ImageView) view2.findViewById(R.id.guild_boost_uncancel_image);
                                if (imageView != null) {
                                    i = R.id.guild_boost_uncancel_nevermind;
                                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.guild_boost_uncancel_nevermind);
                                    if (materialButton != null) {
                                        i = R.id.notice_header_container;
                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                                        if (linearLayout != null) {
                                            return new GuildBoostUncancelDialogBinding((LinearLayout) view2, textView, loadingButton, textView2, appViewFlipper, textView3, imageView, materialButton, linearLayout);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    /* renamed from: b.a.a.a.a$d */
    public static final class d extends Lambda implements Function1<GuildBoostUncancelViewModel3.c, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(GuildBoostUncancelViewModel3.c cVar) {
            GuildBoostUncancelViewModel3.c cVar2 = cVar;
            GuildBoostUncancelDialog guildBoostUncancelDialog = GuildBoostUncancelDialog.this;
            Intrinsics3.checkNotNullExpressionValue(cVar2, "it");
            KProperty[] kPropertyArr = GuildBoostUncancelDialog.j;
            AppViewFlipper appViewFlipper = guildBoostUncancelDialog.g().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostUncancelFlipper");
            appViewFlipper.setDisplayedChild(!(cVar2 instanceof GuildBoostUncancelViewModel3.c.C0009c) ? 1 : 0);
            TextView textView = guildBoostUncancelDialog.g().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostUncancelError");
            boolean z2 = cVar2 instanceof GuildBoostUncancelViewModel3.c.b;
            textView.setVisibility(z2 && ((GuildBoostUncancelViewModel3.c.b) cVar2).c ? 0 : 8);
            MaterialButton materialButton = guildBoostUncancelDialog.g().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildBoostUncancelNevermind");
            materialButton.setVisibility(z2 ? 0 : 8);
            MaterialButton materialButton2 = guildBoostUncancelDialog.g().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.guildBoostUncancelNevermind");
            ViewExtensions.setEnabledAndAlpha$default(materialButton2, z2 && !((GuildBoostUncancelViewModel3.c.b) cVar2).f43b, 0.0f, 2, null);
            guildBoostUncancelDialog.g().c.setIsLoading(z2 && ((GuildBoostUncancelViewModel3.c.b) cVar2).f43b);
            GuildBoostUncancelViewModel3.c.C0009c c0009c = GuildBoostUncancelViewModel3.c.C0009c.a;
            guildBoostUncancelDialog.setCancelable((Intrinsics3.areEqual(cVar2, c0009c) ^ true) && z2 && !((GuildBoostUncancelViewModel3.c.b) cVar2).f43b);
            if (!Intrinsics3.areEqual(cVar2, c0009c)) {
                if (z2) {
                    TextView textView2 = guildBoostUncancelDialog.g().f;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostUncancelHeader");
                    textView2.setText(guildBoostUncancelDialog.getString(R.string.premium_guild_subscription_inventory_uncancel_title_mobile));
                    TextView textView3 = guildBoostUncancelDialog.g().f207b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostUncancelBody");
                    textView3.setText(guildBoostUncancelDialog.getString(R.string.premium_guild_subscription_inventory_uncancel_description));
                } else if (Intrinsics3.areEqual(cVar2, GuildBoostUncancelViewModel3.c.d.a)) {
                    TextView textView4 = guildBoostUncancelDialog.g().f;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildBoostUncancelHeader");
                    textView4.setText(guildBoostUncancelDialog.getString(R.string.premium_guild_subscription_inventory_uncancel_confirm_title));
                    ImageView imageView = guildBoostUncancelDialog.g().g;
                    Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildBoostUncancelImage");
                    imageView.setVisibility(0);
                    TextView textView5 = guildBoostUncancelDialog.g().f207b;
                    Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildBoostUncancelBody");
                    textView5.setText(guildBoostUncancelDialog.getString(R.string.premium_guild_subscription_inventory_uncancel_confirm_description));
                    guildBoostUncancelDialog.g().c.setText(guildBoostUncancelDialog.getString(R.string.okay));
                } else if (cVar2 instanceof GuildBoostUncancelViewModel3.c.a) {
                    Integer num = ((GuildBoostUncancelViewModel3.c.a) cVar2).a;
                    if (num != null) {
                        AppToast.i(guildBoostUncancelDialog, num.intValue(), 0, 4);
                    }
                    guildBoostUncancelDialog.dismiss();
                }
            }
            return Unit.a;
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    /* renamed from: b.a.a.a.a$e */
    public static final class e extends Lambda implements Function0<Long> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            Bundle arguments = GuildBoostUncancelDialog.this.getArguments();
            Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_slot_id")) : null;
            Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildBoostSlotId /* = kotlin.Long */");
            return Long.valueOf(lValueOf.longValue());
        }
    }

    /* compiled from: GuildBoostUncancelDialog.kt */
    /* renamed from: b.a.a.a.a$f */
    public static final class f extends Lambda implements Function0<GuildBoostUncancelViewModel3> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public GuildBoostUncancelViewModel3 invoke() {
            return new GuildBoostUncancelViewModel3(((Number) GuildBoostUncancelDialog.this.slotId.getValue()).longValue(), null, null, null, null, 30);
        }
    }

    public GuildBoostUncancelDialog() {
        super(R.layout.guild_boost_uncancel_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
        f fVar = new f();
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostUncancelViewModel3.class), new defpackage.k(3, appViewModelDelegates3), new AppViewModelDelegates5(fVar));
        this.slotId = LazyJVM.lazy(new e());
    }

    public final GuildBoostUncancelDialogBinding g() {
        return (GuildBoostUncancelDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().h.setOnClickListener(new a(0, this));
        g().c.setOnClickListener(new a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildBoostUncancelViewModel3.c> observableR = ((GuildBoostUncancelViewModel3) this.viewModel.getValue()).observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), GuildBoostUncancelDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
