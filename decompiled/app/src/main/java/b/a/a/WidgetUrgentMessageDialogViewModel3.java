package b.a.a;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetUrgentMessageDialogViewModel.kt */
/* renamed from: b.a.a.x, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUrgentMessageDialogViewModel3 extends AppViewModel<d> {
    public static final a j = new a(null);
    public final PublishSubject<b> k;
    public final RestAPI l;

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    /* renamed from: b.a.a.x$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    /* renamed from: b.a.a.x$b */
    public static abstract class b {

        /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
        /* renamed from: b.a.a.x$b$a */
        public static final class a extends b {
            public static final a a = new a();

            public a() {
                super(null);
            }
        }

        /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
        /* renamed from: b.a.a.x$b$b, reason: collision with other inner class name */
        public static final class C0014b extends b {
            public static final C0014b a = new C0014b();

            public C0014b() {
                super(null);
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    /* renamed from: b.a.a.x$c */
    public static final class c {
        public final User a;

        public c(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.a = user;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && Intrinsics3.areEqual(this.a, ((c) obj).a);
            }
            return true;
        }

        public int hashCode() {
            User user = this.a;
            if (user != null) {
                return user.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.a);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUrgentMessageDialogViewModel.kt */
    /* renamed from: b.a.a.x$d */
    public static final class d {
        public final Integer a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f50b;

        public d(Integer num, boolean z2) {
            this.a = num;
            this.f50b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics3.areEqual(this.a, dVar.a) && this.f50b == dVar.f50b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            boolean z2 = this.f50b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(userFlags=");
            sbU.append(this.a);
            sbU.append(", isBusy=");
            return outline.O(sbU, this.f50b, ")");
        }
    }

    public WidgetUrgentMessageDialogViewModel3() {
        this(null, null, null, 7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrgentMessageDialogViewModel3(RestAPI restAPI, StoreUser storeUser, Observable observable, int i) {
        Observable observableG;
        super(null, 1, null);
        RestAPI api = (i & 1) != 0 ? RestAPI.INSTANCE.getApi() : null;
        StoreUser users = (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : null;
        if ((i & 4) != 0) {
            observableG = StoreUser.observeMe$default(users, false, 1, null).G(WidgetUrgentMessageDialogViewModel2.j);
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeUser.observeMe().ma…oreState(user = meUser) }");
        } else {
            observableG = null;
        }
        Intrinsics3.checkNotNullParameter(api, "restAPI");
        Intrinsics3.checkNotNullParameter(users, "storeUser");
        Intrinsics3.checkNotNullParameter(observableG, "storeObservable");
        this.l = api;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), WidgetUrgentMessageDialogViewModel3.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUrgentMessageDialogViewModel(this), 62, (Object) null);
        this.k = PublishSubject.k0();
    }
}
