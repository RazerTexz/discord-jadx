package com.discord.widgets.notice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetNoticeNuxSamsungLinkBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetNoticeNuxSamsungLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/notice/WidgetNoticeNuxSamsungLink;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetNoticeNuxSamsungLinkBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetNoticeNuxSamsungLinkBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNoticeNuxSamsungLink.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeNuxSamsungLinkBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NOTICE_NAME = "NUX/SamsungLink";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetNoticeNuxSamsungLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/notice/WidgetNoticeNuxSamsungLink$Companion;", "", "", "internalEnqueue", "()V", "Landroid/content/Context;", "context", "Lcom/discord/utilities/time/Clock;", "clock", "enqueue", "(Landroid/content/Context;Lcom/discord/utilities/time/Clock;)V", "", "NOTICE_NAME", "Ljava/lang/String;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$internalEnqueue(Companion companion) {
            companion.internalEnqueue();
        }

        private final void internalEnqueue() {
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetNoticeNuxSamsungLink.NOTICE_NAME, null, 0L, 0, true, null, 0L, false, RecyclerView.FOREVER_NS, WidgetNoticeNuxSamsungLink4.INSTANCE, 230, null));
        }

        public final void enqueue(Context context, Clock clock) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(clock, "clock");
            if (Build.VERSION.SDK_INT >= 28 && StringsJVM.equals(Build.MANUFACTURER, "samsung", true)) {
                Intrinsics3.checkNotNullParameter(context, "context");
                try {
                    try {
                    } catch (PackageManager.NameNotFoundException unused) {
                        if (context.getPackageManager().getPackageInfo("com.samsung.android.game.gamehome", 0) != null) {
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                boolean z2 = context.getPackageManager().getPackageInfo("com.samsung.android.game.gametools", 0) != null;
                if (z2) {
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    Observable observableJ = Observable.j(companion.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), WidgetNoticeNuxSamsungLink2.INSTANCE);
                    Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n          .co…hed to meUser\n          }");
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableJ, 0L, false, 3, null)), WidgetNoticeNuxSamsungLink.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetNoticeNuxSamsungLink3(clock), 62, (Object) null);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNoticeNuxSamsungLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/domain/ModelOAuth2Token;", "kotlin.jvm.PlatformType", "authedApps", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelOAuth2Token>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelOAuth2Token> list) {
            invoke2((List<ModelOAuth2Token>) list);
            return Unit.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0051 A[EDGE_INSN: B:26:0x0051->B:22:0x0051 BREAK  A[LOOP:0: B:8:0x0017->B:29:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[LOOP:0: B:8:0x0017->B:29:?, LOOP_END, SYNTHETIC] */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(List<ModelOAuth2Token> list) {
            boolean z2;
            Intrinsics3.checkNotNullExpressionValue(list, "authedApps");
            boolean z3 = true;
            if ((list instanceof Collection) && list.isEmpty()) {
                z3 = false;
            } else {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics3.areEqual(String.valueOf(((ModelOAuth2Token) it.next()).getApplication().getId()), "591317049637339146")) {
                        if (Build.VERSION.SDK_INT >= 28 && StringsJVM.equals(Build.MANUFACTURER, "samsung", true)) {
                            z2 = true;
                        }
                        if (!z2) {
                        }
                    } else {
                        z2 = false;
                        if (!z2) {
                            break;
                        }
                    }
                }
                z3 = false;
            }
            if (z3) {
                WidgetNoticeNuxSamsungLink.this.dismiss();
            }
        }
    }

    /* compiled from: WidgetNoticeNuxSamsungLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeNuxSamsungLink widgetNoticeNuxSamsungLink = WidgetNoticeNuxSamsungLink.this;
            Uri oauth2Authorize = IntentUtils.RouteBuilders.Uris.INSTANCE.getOauth2Authorize();
            Intrinsics3.checkNotNullParameter(oauth2Authorize, "oAuthUri");
            widgetNoticeNuxSamsungLink.startActivity(new Intent("android.intent.action.VIEW", oauth2Authorize.buildUpon().appendQueryParameter("client_id", "591317049637339146").appendQueryParameter("prompt", "consent").appendQueryParameter("response_type", ModelAuditLogEntry.CHANGE_KEY_CODE).appendQueryParameter("scope", "identify activities.read activities.write").build()));
            WidgetNoticeNuxSamsungLink.this.dismiss();
        }
    }

    /* compiled from: WidgetNoticeNuxSamsungLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeNuxSamsungLink.this.dismiss();
        }
    }

    public WidgetNoticeNuxSamsungLink() {
        super(R.layout.widget_notice_nux_samsung_link);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNoticeNuxSamsungLink5.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeNuxSamsungLinkBinding getBinding() {
        return (WidgetNoticeNuxSamsungLinkBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.INSTANCE.getNotices().markDialogSeen(NOTICE_NAME);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getOAuthTokens(), false, 1, null)), 0L, false, 1, null), this, null, 2, null), WidgetNoticeNuxSamsungLink.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().f2502b.setOnClickListener(new AnonymousClass3());
    }
}
