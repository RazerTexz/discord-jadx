package b.a.a.d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.d.UserActionsDialogViewModel5;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.UserActionsDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.UserNameFormatter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.k;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: UserActionsDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lb/a/a/d/a;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lb/a/i/u1;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/u1;", "binding", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "n", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "imagesChangeDetector", "Lb/a/a/d/f;", "m", "Lkotlin/Lazy;", "h", "()Lb/a/a/d/f;", "viewModel", "<init>", "k", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.d.a, reason: use source file name */
/* loaded from: classes.dex */
public final class UserActionsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(UserActionsDialog.class, "binding", "getBinding()Lcom/discord/databinding/UserActionsDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* renamed from: n, reason: from kotlin metadata */
    public final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.d.a$a */
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
                UserActionsDialog userActionsDialog = (UserActionsDialog) this.k;
                KProperty[] kPropertyArr = UserActionsDialog.j;
                UserActionsDialogViewModel5 userActionsDialogViewModel5H = userActionsDialog.h();
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(userActionsDialogViewModel5H.m, "User Profile", userActionsDialogViewModel5H.l, 2, null, null, 24, null), false, 1, null), userActionsDialogViewModel5H, null, 2, null), UserActionsDialogViewModel5.class, (Context) null, (Function1) null, new UserActionsDialogViewModel7(userActionsDialogViewModel5H), (Function0) null, (Function0) null, new UserActionsDialogViewModel6(userActionsDialogViewModel5H), 54, (Object) null);
                return;
            }
            if (i == 1) {
                UserActionsDialog userActionsDialog2 = (UserActionsDialog) this.k;
                KProperty[] kPropertyArr2 = UserActionsDialog.j;
                userActionsDialog2.h().removeRelationship(R.string.user_has_been_unblocked);
            } else {
                if (i != 2) {
                    throw null;
                }
                UserActionsDialog userActionsDialog3 = (UserActionsDialog) this.k;
                KProperty[] kPropertyArr3 = UserActionsDialog.j;
                userActionsDialog3.h().removeRelationship(R.string.friend_has_been_deleted);
            }
        }
    }

    /* compiled from: UserActionsDialog.kt */
    /* renamed from: b.a.a.d.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UserActionsDialog.kt */
    /* renamed from: b.a.a.d.a$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, UserActionsDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, UserActionsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/UserActionsDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public UserActionsDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.user_actions_dialog_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.user_actions_dialog_avatar);
            if (simpleDraweeView != null) {
                i = R.id.user_actions_dialog_block_item;
                TextView textView = (TextView) view2.findViewById(R.id.user_actions_dialog_block_item);
                if (textView != null) {
                    i = R.id.user_actions_dialog_remove_friend_item;
                    TextView textView2 = (TextView) view2.findViewById(R.id.user_actions_dialog_remove_friend_item);
                    if (textView2 != null) {
                        i = R.id.user_actions_dialog_unblock_item;
                        TextView textView3 = (TextView) view2.findViewById(R.id.user_actions_dialog_unblock_item);
                        if (textView3 != null) {
                            i = R.id.user_actions_dialog_user_name;
                            TextView textView4 = (TextView) view2.findViewById(R.id.user_actions_dialog_user_name);
                            if (textView4 != null) {
                                return new UserActionsDialogBinding((LinearLayout) view2, simpleDraweeView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: b.a.a.d.a$d */
    public static final class d<T, R> implements Func1<Object, Boolean> {
        public static final d j = new d();

        @Override // j0.k.Func1
        public Boolean call(Object obj) {
            return Boolean.valueOf(obj instanceof UserActionsDialogViewModel5.d.a);
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: b.a.a.d.a$e */
    public static final class e<T, R> implements Func1<Object, T> {
        public static final e j = new e();

        @Override // j0.k.Func1
        public final T call(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.dialogs.useractions.UserActionsDialogViewModel.ViewState.Loaded");
            return (T) ((UserActionsDialogViewModel5.d.a) obj);
        }
    }

    /* compiled from: UserActionsDialog.kt */
    /* renamed from: b.a.a.d.a$f */
    public static final /* synthetic */ class f extends FunctionReferenceImpl implements Function1<UserActionsDialogViewModel5.d.a, Unit> {
        public f(UserActionsDialog userActionsDialog) {
            super(1, userActionsDialog, UserActionsDialog.class, "updateView", "updateView(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(UserActionsDialogViewModel5.d.a aVar) {
            UserActionsDialogViewModel5.d.a aVar2 = aVar;
            Intrinsics3.checkNotNullParameter(aVar2, "p1");
            UserActionsDialog userActionsDialog = (UserActionsDialog) this.receiver;
            KProperty[] kPropertyArr = UserActionsDialog.j;
            SimpleDraweeView simpleDraweeView = userActionsDialog.g().f209b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userActionsDialogAvatar");
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(aVar2.a, true, null, 4, null), 0, (Function1) null, userActionsDialog.imagesChangeDetector, 12, (Object) null);
            TextView textView = userActionsDialog.g().f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.userActionsDialogUserName");
            User user = aVar2.a;
            String str = aVar2.f47b;
            Context contextRequireContext = userActionsDialog.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(UserNameFormatter.getSpannableForUserNameWithDiscrim(user, str, contextRequireContext, R.attr.colorHeaderPrimary, R.attr.font_primary_semibold, R.integer.uikit_textsize_large_sp, R.attr.colorTextMuted, R.attr.font_primary_normal, R.integer.uikit_textsize_large_sp));
            TextView textView2 = userActionsDialog.g().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.userActionsDialogBlockItem");
            textView2.setVisibility(aVar2.c ? 0 : 8);
            TextView textView3 = userActionsDialog.g().e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.userActionsDialogUnblockItem");
            textView3.setVisibility(aVar2.d ? 0 : 8);
            TextView textView4 = userActionsDialog.g().d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.userActionsDialogRemoveFriendItem");
            textView4.setVisibility(aVar2.e ? 0 : 8);
            return Unit.a;
        }
    }

    /* compiled from: UserActionsDialog.kt */
    /* renamed from: b.a.a.d.a$g */
    public static final /* synthetic */ class g extends FunctionReferenceImpl implements Function1<UserActionsDialogViewModel5.b, Unit> {
        public g(UserActionsDialog userActionsDialog) {
            super(1, userActionsDialog, UserActionsDialog.class, "handleEvent", "handleEvent(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(UserActionsDialogViewModel5.b bVar) {
            UserActionsDialogViewModel5.b bVar2 = bVar;
            Intrinsics3.checkNotNullParameter(bVar2, "p1");
            UserActionsDialog userActionsDialog = (UserActionsDialog) this.receiver;
            KProperty[] kPropertyArr = UserActionsDialog.j;
            Objects.requireNonNull(userActionsDialog);
            if (bVar2 instanceof UserActionsDialogViewModel5.b.C0011b) {
                AppToast.i(userActionsDialog, ((UserActionsDialogViewModel5.b.C0011b) bVar2).a, 0, 4);
                userActionsDialog.dismiss();
            } else if (bVar2 instanceof UserActionsDialogViewModel5.b.a) {
                AppToast.i(userActionsDialog, ((UserActionsDialogViewModel5.b.a) bVar2).a, 0, 4);
                userActionsDialog.dismiss();
            }
            return Unit.a;
        }
    }

    /* compiled from: UserActionsDialog.kt */
    /* renamed from: b.a.a.d.a$h */
    public static final class h extends Lambda implements Function0<UserActionsDialogViewModel5> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public UserActionsDialogViewModel5 invoke() {
            UserActionsDialog userActionsDialog = UserActionsDialog.this;
            KProperty[] kPropertyArr = UserActionsDialog.j;
            return new UserActionsDialogViewModel5(userActionsDialog.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", 0L), UserActionsDialog.this.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), null, null, 12);
        }
    }

    public UserActionsDialog() {
        super(R.layout.user_actions_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
        h hVar = new h();
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(UserActionsDialogViewModel5.class), new k(4, appViewModelDelegates3), new AppViewModelDelegates5(hVar));
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
    }

    public final UserActionsDialogBinding g() {
        return (UserActionsDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    public final UserActionsDialogViewModel5 h() {
        return (UserActionsDialogViewModel5) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().c.setOnClickListener(new a(0, this));
        g().e.setOnClickListener(new a(1, this));
        g().d.setOnClickListener(new a(2, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableG = h().observeViewState().y(d.j).G(e.j);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), UserActionsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new f(this), 62, (Object) null);
        PublishSubject<UserActionsDialogViewModel5.b> publishSubject = h().k;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(publishSubject, this, null, 2, null), UserActionsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new g(this), 62, (Object) null);
    }
}
