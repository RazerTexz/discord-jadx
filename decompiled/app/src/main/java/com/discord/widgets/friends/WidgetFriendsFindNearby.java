package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppHelpDesk;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFriendsNearbyBinding;
import com.discord.rlottie.RLottieDrawable;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.friends.NearbyManager;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.WidgetFriendsAddUserRequestsModel;
import defpackage.WidgetFriendsAddUserRequestsModel2;
import defpackage.WidgetFriendsAddUserRequestsModel3;
import defpackage.j;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/* compiled from: WidgetFriendsFindNearby.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002BCB\u0007¢\u0006\u0004\bA\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u001b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u001dJ\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u001dJ\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u001dR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001d\u00101\u001a\u00020,8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00104\u001a\b\u0012\u0004\u0012\u000203028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u00106\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001d\u0010=\u001a\u0002088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsFindNearby;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;)V", "Lcom/discord/utilities/error/Error;", "error", "launchCaptchaFlow", "(Lcom/discord/utilities/error/Error;)V", "", "username", "", "discriminator", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "sendFriendRequest", "(Ljava/lang/String;ILcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "", "Lcom/discord/primitives/UserId;", "userId", "acceptFriendRequest", "(J)V", "", "incomingFriendRequest", "declineFriendRequest", "(JZ)V", "enableScanning", "()V", "updateMeUserIdAndInitNearbyManager", "resultCode", "getErrorMessage", "(Ljava/lang/Integer;)Ljava/lang/String;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "onResume", "onPause", "Lcom/discord/widgets/friends/NearbyManager;", "nearbyManager", "Lcom/discord/widgets/friends/NearbyManager;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearbyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/friends/WidgetFriendsFindNearbyViewModel;", "viewModel", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "captchaLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "meUserId", "Ljava/lang/Long;", "Lcom/discord/databinding/WidgetFriendsNearbyBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetFriendsNearbyBinding;", "binding", "Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter;", "resultsAdapter", "Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter;", "<init>", ExifInterface.TAG_MODEL, "ModelProvider", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearby extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFriendsFindNearby.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private Long meUserId;
    private final NearbyManager nearbyManager;
    private WidgetFriendsAddUserAdapter resultsAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", "", "<init>", "()V", "Empty", "Error", "NearbyUsers", "Uninitialized", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$NearbyUsers;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$Empty;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$Error;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$Uninitialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Model {

        /* compiled from: WidgetFriendsFindNearby.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$Empty;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends Model {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* compiled from: WidgetFriendsFindNearby.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$Error;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", "", "component1", "()Ljava/lang/Integer;", "errorCode", "copy", "(Ljava/lang/Integer;)Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$Error;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getErrorCode", "<init>", "(Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Error extends Model {
            private final Integer errorCode;

            public Error(Integer num) {
                super(null);
                this.errorCode = num;
            }

            public static /* synthetic */ Error copy$default(Error error, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = error.errorCode;
                }
                return error.copy(num);
            }

            /* renamed from: component1, reason: from getter */
            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public final Error copy(Integer errorCode) {
                return new Error(errorCode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && Intrinsics3.areEqual(this.errorCode, ((Error) other).errorCode);
                }
                return true;
            }

            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public int hashCode() {
                Integer num = this.errorCode;
                if (num != null) {
                    return num.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.F(outline.U("Error(errorCode="), this.errorCode, ")");
            }
        }

        /* compiled from: WidgetFriendsFindNearby.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$NearbyUsers;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", "", "Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$NearbyUsers;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class NearbyUsers extends Model {
            private final List<WidgetFriendsAddUserAdapter.ItemUser> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NearbyUsers(List<WidgetFriendsAddUserAdapter.ItemUser> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ NearbyUsers copy$default(NearbyUsers nearbyUsers, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = nearbyUsers.items;
                }
                return nearbyUsers.copy(list);
            }

            public final List<WidgetFriendsAddUserAdapter.ItemUser> component1() {
                return this.items;
            }

            public final NearbyUsers copy(List<WidgetFriendsAddUserAdapter.ItemUser> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new NearbyUsers(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof NearbyUsers) && Intrinsics3.areEqual(this.items, ((NearbyUsers) other).items);
                }
                return true;
            }

            public final List<WidgetFriendsAddUserAdapter.ItemUser> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<WidgetFriendsAddUserAdapter.ItemUser> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("NearbyUsers(items="), this.items, ")");
            }
        }

        /* compiled from: WidgetFriendsFindNearby.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$Uninitialized;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends Model {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsFindNearby$ModelProvider;", "", "", "", "Lcom/discord/primitives/UserId;", "userIds", "Lrx/Observable;", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model$NearbyUsers;", "getUserModels", "(Ljava/util/Collection;)Lrx/Observable;", "Lcom/discord/widgets/friends/NearbyManager$NearbyState;", "nearbyStateObservable", "Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", "get", "(Lrx/Observable;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public static final /* synthetic */ Observable access$getUserModels(ModelProvider modelProvider, Collection collection) {
            return modelProvider.getUserModels(collection);
        }

        private final Observable<Model.NearbyUsers> getUserModels(Collection<Long> userIds) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model.NearbyUsers> observableI = Observable.i(companion.getUsers().observeUsers(userIds, true), companion.getPresences().observePresencesForUsers(userIds), companion.getUserRelationships().observe(userIds), WidgetFriendsFindNearby3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n          .co…yUsers(items)\n          }");
            return observableI;
        }

        public final Observable<Model> get(Observable<NearbyManager.NearbyState> nearbyStateObservable) {
            Intrinsics3.checkNotNullParameter(nearbyStateObservable, "nearbyStateObservable");
            Observable observableY = nearbyStateObservable.Y(WidgetFriendsFindNearby2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "nearbyStateObservable\n  …          }\n            }");
            return observableY;
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$acceptFriendRequest$1, reason: invalid class name */
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
        public final void invoke2(Void r5) {
            AppToast.g(WidgetFriendsFindNearby.this.getContext(), R.string.accept_request_button_after, 0, null, 12);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$declineFriendRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r5) {
            AppToast.g(WidgetFriendsFindNearby.this.getContext(), this.$successMessageStringRes, 0, null, 12);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "username", "", "discriminator", "", "invoke", "(Ljava/lang/String;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<String, Integer, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
            invoke(str, num.intValue());
            return Unit.a;
        }

        public final void invoke(String str, int i) {
            Intrinsics3.checkNotNullParameter(str, "username");
            WidgetFriendsFindNearby.sendFriendRequest$default(WidgetFriendsFindNearby.this, str, i, null, 4, null);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetFriendsFindNearby.access$acceptFriendRequest(WidgetFriendsFindNearby.this, j);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "", "incomingFriendRequest", "", "invoke", "(JZ)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<Long, Boolean, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetFriendsFindNearby.access$declineFriendRequest(WidgetFriendsFindNearby.this, j, z2);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetFriendsFindNearby.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsFindNearby.access$enableScanning(WidgetFriendsFindNearby.this);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view, "it", "it.context"), AppHelpDesk.a.a(360014894392L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LWidgetFriendsAddUserRequestsModel;", "kotlin.jvm.PlatformType", "model", "", "invoke", "(LWidgetFriendsAddUserRequestsModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetFriendsAddUserRequestsModel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            invoke2(widgetFriendsAddUserRequestsModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel) {
            WidgetFriendsFindNearby.access$getResultsAdapter$p(WidgetFriendsFindNearby.this).addFriendRequestUserIds(widgetFriendsAddUserRequestsModel.outgoingIds, widgetFriendsAddUserRequestsModel.incomingIds);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;", "it", "", "invoke", "(Lcom/discord/widgets/friends/WidgetFriendsFindNearby$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetFriendsFindNearby.access$configureUI(WidgetFriendsFindNearby.this, model);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public final /* synthetic */ String $username;

        public AnonymousClass1(String str) {
            this.$username = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r7) {
            Context context = WidgetFriendsFindNearby.this.getContext();
            Context context2 = WidgetFriendsFindNearby.this.getContext();
            AppToast.h(context, context2 != null ? FormatUtils.h(context2, R.string.add_friend_confirmation, new Object[]{this.$username}, null, 4) : null, 0, null, 12);
        }
    }

    /* compiled from: WidgetFriendsFindNearby.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "error", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public final /* synthetic */ int $discriminator;
        public final /* synthetic */ String $username;

        /* compiled from: WidgetFriendsFindNearby.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$sendFriendRequest$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Error error = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                if (WidgetCaptcha4.isCaptchaError(error)) {
                    WidgetFriendsFindNearby widgetFriendsFindNearby = WidgetFriendsFindNearby.this;
                    Error error2 = this.$error;
                    Intrinsics3.checkNotNullExpressionValue(error2, "error");
                    WidgetFriendsFindNearby.access$launchCaptchaFlow(widgetFriendsFindNearby, error2);
                    return;
                }
                RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                Context context = WidgetFriendsFindNearby.this.getContext();
                Error error3 = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error3, "error");
                Error.Response response = error3.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                AppToast.h(WidgetFriendsFindNearby.this.getContext(), responseResolver.getRelationshipResponse(context, response.getCode(), AnonymousClass2.this.$username + MentionUtils.CHANNELS_CHAR + UserUtils.INSTANCE.padDiscriminator(AnonymousClass2.this.$discriminator)), 0, null, 12);
            }
        }

        public AnonymousClass2(String str, int i) {
            this.$username = str;
            this.$discriminator = i;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    public WidgetFriendsFindNearby() {
        super(R.layout.widget_friends_nearby);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFriendsFindNearby4.INSTANCE, null, 2, null);
        WidgetFriendsFindNearby6 widgetFriendsFindNearby6 = WidgetFriendsFindNearby6.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetFriendsFindNearbyViewModel.class), new WidgetFriendsFindNearby$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFriendsFindNearby6));
        this.nearbyManager = new NearbyManager();
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetFriendsFindNearby5(this));
    }

    private final void acceptFriendRequest(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(RestAPI.INSTANCE.getApi(), "Nearby - Accept Friend Request", userId, null, null, null, 28, null), false, 1, null), this, null, 2, null), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public static final /* synthetic */ void access$acceptFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, long j) {
        widgetFriendsFindNearby.acceptFriendRequest(j);
    }

    public static final /* synthetic */ void access$configureUI(WidgetFriendsFindNearby widgetFriendsFindNearby, Model model) {
        widgetFriendsFindNearby.configureUI(model);
    }

    public static final /* synthetic */ void access$declineFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, long j, boolean z2) {
        widgetFriendsFindNearby.declineFriendRequest(j, z2);
    }

    public static final /* synthetic */ void access$enableScanning(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        widgetFriendsFindNearby.enableScanning();
    }

    public static final /* synthetic */ WidgetFriendsAddUserAdapter access$getResultsAdapter$p(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = widgetFriendsFindNearby.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        return widgetFriendsAddUserAdapter;
    }

    public static final /* synthetic */ WidgetFriendsFindNearbyViewModel access$getViewModel$p(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        return widgetFriendsFindNearby.getViewModel();
    }

    public static final /* synthetic */ void access$launchCaptchaFlow(WidgetFriendsFindNearby widgetFriendsFindNearby, Error error) {
        widgetFriendsFindNearby.launchCaptchaFlow(error);
    }

    public static final /* synthetic */ void access$sendFriendRequest(WidgetFriendsFindNearby widgetFriendsFindNearby, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetFriendsFindNearby.sendFriendRequest(str, i, captchaPayload);
    }

    public static final /* synthetic */ void access$setResultsAdapter$p(WidgetFriendsFindNearby widgetFriendsFindNearby, WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        widgetFriendsFindNearby.resultsAdapter = widgetFriendsAddUserAdapter;
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Uninitialized) {
            TextView textView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.nearbyFriendsSearchingTitle");
            textView.setText(getString(R.string.add_friend_nearby_title));
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nearbyFriendsSearchingBody");
            textView2.setText(getString(R.string.add_friend_nearby_body));
            TextView textView3 = getBinding().e;
            TextView textView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.nearbyFriendsSearchingBody");
            textView3.setTextColor(ColorCompat.getThemedColor(textView4, R.attr.colorHeaderSecondary));
            MaterialButton materialButton = getBinding().f2399b;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.nearbyFriendsEnable");
            materialButton.setVisibility(0);
            RecyclerView recyclerView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
            recyclerView.setVisibility(8);
            RLottieImageView rLottieImageView = getBinding().f;
            RLottieDrawable rLottieDrawable = rLottieImageView.drawable;
            if (rLottieDrawable == null) {
                return;
            }
            rLottieImageView.playing = false;
            if (rLottieImageView.attachedToWindow) {
                rLottieDrawable.P = false;
                return;
            }
            return;
        }
        if (model instanceof Model.Error) {
            TextView textView5 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.nearbyFriendsSearchingTitle");
            textView5.setText(getString(R.string.add_friend_nearby_title));
            TextView textView6 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.nearbyFriendsSearchingBody");
            textView6.setText(getErrorMessage(((Model.Error) model).getErrorCode()));
            TextView textView7 = getBinding().e;
            TextView textView8 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.nearbyFriendsSearchingBody");
            textView7.setTextColor(ColorCompat.getColor(textView8, R.color.status_red_500));
            MaterialButton materialButton2 = getBinding().f2399b;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.nearbyFriendsEnable");
            materialButton2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.nearbyFriendsRecycler");
            recyclerView2.setVisibility(8);
            RLottieImageView rLottieImageView2 = getBinding().f;
            RLottieDrawable rLottieDrawable2 = rLottieImageView2.drawable;
            if (rLottieDrawable2 == null) {
                return;
            }
            rLottieImageView2.playing = false;
            if (rLottieImageView2.attachedToWindow) {
                rLottieDrawable2.P = false;
                return;
            }
            return;
        }
        if (model instanceof Model.Empty) {
            TextView textView9 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView9, "binding.nearbyFriendsSearchingTitle");
            textView9.setText(getString(R.string.add_friend_nearby_title));
            TextView textView10 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView10, "binding.nearbyFriendsSearchingBody");
            textView10.setText(getString(R.string.add_friend_nearby_body));
            TextView textView11 = getBinding().e;
            TextView textView12 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView12, "binding.nearbyFriendsSearchingBody");
            textView11.setTextColor(ColorCompat.getThemedColor(textView12, R.attr.colorHeaderSecondary));
            MaterialButton materialButton3 = getBinding().f2399b;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.nearbyFriendsEnable");
            materialButton3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.nearbyFriendsRecycler");
            recyclerView3.setVisibility(8);
            if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
                return;
            }
            getBinding().f.b();
            return;
        }
        if (model instanceof Model.NearbyUsers) {
            TextView textView13 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView13, "binding.nearbyFriendsSearchingTitle");
            textView13.setText(getString(R.string.add_friend_nearby_found_title));
            TextView textView14 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView14, "binding.nearbyFriendsSearchingBody");
            textView14.setText(getString(R.string.add_friend_nearby_found_body));
            TextView textView15 = getBinding().e;
            TextView textView16 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView16, "binding.nearbyFriendsSearchingBody");
            textView15.setTextColor(ColorCompat.getThemedColor(textView16, R.attr.colorHeaderSecondary));
            MaterialButton materialButton4 = getBinding().f2399b;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.nearbyFriendsEnable");
            materialButton4.setVisibility(8);
            WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
            if (widgetFriendsAddUserAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
            }
            widgetFriendsAddUserAdapter.setData(((Model.NearbyUsers) model).getItems());
            RecyclerView recyclerView4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.nearbyFriendsRecycler");
            recyclerView4.setVisibility(0);
        }
    }

    private final void declineFriendRequest(long userId, boolean incomingFriendRequest) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeRelationship("Nearby - Remove Friend Request", userId), false, 1, null), this, null, 2, null), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(incomingFriendRequest ? R.string.friend_request_ignored : R.string.friend_request_cancelled), 62, (Object) null);
    }

    private final void enableScanning() {
        if (this.meUserId == null) {
            updateMeUserIdAndInitNearbyManager();
        }
        if (this.meUserId != null) {
            NearbyManager nearbyManager = this.nearbyManager;
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            nearbyManager.buildClientAndPublish(activity);
        }
    }

    private final WidgetFriendsNearbyBinding getBinding() {
        return (WidgetFriendsNearbyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getErrorMessage(Integer resultCode) {
        if (resultCode != null && resultCode.intValue() == 99) {
            Context context = getContext();
            if (context != null) {
                return context.getString(R.string.add_friend_nearby_connection_error);
            }
            return null;
        }
        if (resultCode != null && resultCode.intValue() == 98) {
            Context context2 = getContext();
            if (context2 != null) {
                return context2.getString(R.string.add_friend_nearby_stopped);
            }
            return null;
        }
        Context context3 = getContext();
        if (context3 != null) {
            return context3.getString(R.string.add_friend_nearby_generic_error);
        }
        return null;
    }

    private final WidgetFriendsFindNearbyViewModel getViewModel() {
        return (WidgetFriendsFindNearbyViewModel) this.viewModel.getValue();
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.INSTANCE.launch(requireContext(), this.captchaLauncher, CaptchaErrorBody.INSTANCE.createFromError(error));
    }

    private final void sendFriendRequest(String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        getViewModel().setUsername(username);
        getViewModel().setDiscriminator(Integer.valueOf(discriminator));
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Nearby - Add Friend Suggestion", username, discriminator, captchaPayload), this, null, 2, null).k(o.h(new AnonymousClass1(username), getAppActivity(), new AnonymousClass2(username, discriminator)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetFriendsFindNearby widgetFriendsFindNearby, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaPayload = null;
        }
        widgetFriendsFindNearby.sendFriendRequest(str, i, captchaPayload);
    }

    private final void updateMeUserIdAndInitNearbyManager() {
        long id2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
        this.meUserId = Long.valueOf(id2);
        this.nearbyManager.initialize(id2);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.nearbyManager.disableNearby();
        super.onPause();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        enableScanning();
        AnalyticsTracker.INSTANCE.friendAddViewed("Nearby");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        updateMeUserIdAndInitNearbyManager();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.nearbyFriendsRecycler");
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = (WidgetFriendsAddUserAdapter) companion.configure(new WidgetFriendsAddUserAdapter(recyclerView));
        this.resultsAdapter = widgetFriendsAddUserAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter.setSendHandler(new AnonymousClass1());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter2 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter2.setAcceptHandler(new AnonymousClass2());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter3 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter3.setDeclineHandler(new AnonymousClass3());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter4 = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetFriendsAddUserAdapter4.setOnItemClick(new AnonymousClass4());
        getBinding().f2399b.setOnClickListener(new AnonymousClass5());
        getBinding().c.setOnClickListener(AnonymousClass6.INSTANCE);
        getBinding().f.c(R.raw.anim_friends_add_nearby_looking, DimenUtils.dpToPixels(200), DimenUtils.dpToPixels(200));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<R> observableG = companion.getUserRelationships().observeForType(4).G(j.j);
        Observable<R> observableG2 = companion.getUserRelationships().observeForType(3).G(j.k);
        WidgetFriendsAddUserRequestsModel2 widgetFriendsAddUserRequestsModel2 = WidgetFriendsAddUserRequestsModel2.j;
        Object widgetFriendsAddUserRequestsModel3 = widgetFriendsAddUserRequestsModel2;
        if (widgetFriendsAddUserRequestsModel2 != null) {
            widgetFriendsAddUserRequestsModel3 = new WidgetFriendsAddUserRequestsModel3(widgetFriendsAddUserRequestsModel2);
        }
        Observable observableJ = Observable.j(observableG, observableG2, (Func2) widgetFriendsAddUserRequestsModel3);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…erRequestsModel\n        )");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.ui$default(observableR, this, null, 2, null).k(o.a.g(getContext(), new AnonymousClass1(), null));
        Observable<Model> observable = ModelProvider.INSTANCE.get(this.nearbyManager.getState());
        WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter = this.resultsAdapter;
        if (widgetFriendsAddUserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observable, this, widgetFriendsAddUserAdapter), WidgetFriendsFindNearby.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
