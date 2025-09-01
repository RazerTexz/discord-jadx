package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetFriendsAddByIdBinding;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringNumberConversions;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.functions.Action1;

/* compiled from: WidgetFriendsAddById.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b.\u0010!J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010!J\u0019\u0010#\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b#\u0010\u001fR\u001d\u0010)\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsAddById;", "Lcom/discord/app/AppFragment;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "setInputText", "(Ljava/lang/String;)V", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "extractTargetAndSendFriendRequest", "(Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "Lcom/discord/utilities/error/Error;", "error", "launchCaptchaFlow", "(Lcom/discord/utilities/error/Error;)V", "username", "", "discriminator", "sendFriendRequest", "(Ljava/lang/String;ILcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "", "setInputEditError", "(Ljava/lang/CharSequence;)V", "Lcom/discord/models/user/User;", "user", "Landroid/text/SpannableStringBuilder;", "getUsernameIndicatorText", "(Lcom/discord/models/user/User;)Landroid/text/SpannableStringBuilder;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "()V", "onPause", "hideKeyboard", "Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", "binding", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "captchaLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsAddById extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFriendsAddById.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex PATTERN_USERNAME = new Regex("^(.*)#(\\d{4})$");

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* compiled from: WidgetFriendsAddById.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsAddById$Companion;", "", "", "source", "Lcom/discord/widgets/friends/WidgetFriendsAddById$Companion$UserNameDiscriminator;", "extractUsernameAndDiscriminator", "(Ljava/lang/CharSequence;)Lcom/discord/widgets/friends/WidgetFriendsAddById$Companion$UserNameDiscriminator;", "Lkotlin/text/Regex;", "PATTERN_USERNAME", "Lkotlin/text/Regex;", "<init>", "()V", "UserNameDiscriminator", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetFriendsAddById.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsAddById$Companion$UserNameDiscriminator;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "username", "discriminator", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/discord/widgets/friends/WidgetFriendsAddById$Companion$UserNameDiscriminator;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getDiscriminator", "Ljava/lang/String;", "getUsername", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class UserNameDiscriminator {
            private final Integer discriminator;
            private final String username;

            public UserNameDiscriminator(String str, Integer num) {
                Intrinsics3.checkNotNullParameter(str, "username");
                this.username = str;
                this.discriminator = num;
            }

            public static /* synthetic */ UserNameDiscriminator copy$default(UserNameDiscriminator userNameDiscriminator, String str, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userNameDiscriminator.username;
                }
                if ((i & 2) != 0) {
                    num = userNameDiscriminator.discriminator;
                }
                return userNameDiscriminator.copy(str, num);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            /* renamed from: component2, reason: from getter */
            public final Integer getDiscriminator() {
                return this.discriminator;
            }

            public final UserNameDiscriminator copy(String username, Integer discriminator) {
                Intrinsics3.checkNotNullParameter(username, "username");
                return new UserNameDiscriminator(username, discriminator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UserNameDiscriminator)) {
                    return false;
                }
                UserNameDiscriminator userNameDiscriminator = (UserNameDiscriminator) other;
                return Intrinsics3.areEqual(this.username, userNameDiscriminator.username) && Intrinsics3.areEqual(this.discriminator, userNameDiscriminator.discriminator);
            }

            public final Integer getDiscriminator() {
                return this.discriminator;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                String str = this.username;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Integer num = this.discriminator;
                return iHashCode + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("UserNameDiscriminator(username=");
                sbU.append(this.username);
                sbU.append(", discriminator=");
                return outline.F(sbU, this.discriminator, ")");
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ UserNameDiscriminator access$extractUsernameAndDiscriminator(Companion companion, CharSequence charSequence) {
            return companion.extractUsernameAndDiscriminator(charSequence);
        }

        private final UserNameDiscriminator extractUsernameAndDiscriminator(CharSequence source) {
            List<String> groupValues;
            MatchResult matchResultMatchEntire = WidgetFriendsAddById.access$getPATTERN_USERNAME$cp().matchEntire(source);
            return (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null || !(groupValues.isEmpty() ^ true)) ? new UserNameDiscriminator(source.toString(), null) : new UserNameDiscriminator(matchResultMatchEntire.getGroupValues().get(1), StringNumberConversions.toIntOrNull(matchResultMatchEntire.getGroupValues().get(2)));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsAddById.extractTargetAndSendFriendRequest$default(WidgetFriendsAddById.this, null, 1, null);
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            try {
                boolean z2 = true;
                if (editable.length() == 0) {
                    WidgetFriendsAddById.access$setInputEditError(WidgetFriendsAddById.this, null);
                }
                MaterialButton materialButton = WidgetFriendsAddById.access$getBinding$p(WidgetFriendsAddById.this).d;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.friendsAddSend");
                if (editable.length() <= 0) {
                    z2 = false;
                }
                materialButton.setEnabled(z2);
            } catch (Exception unused) {
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("Detached: ");
                sbU.append(WidgetFriendsAddById.this.isDetached());
                sbU.append(" Visible: ");
                sbU.append(WidgetFriendsAddById.this.isVisible());
                Logger.e$default(appLog, "Failed to update views via TextWatcher", new Exception(sbU.toString()), null, 4, null);
            }
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetFriendsAddById.extractTargetAndSendFriendRequest$default(WidgetFriendsAddById.this, null, 1, null);
            AppFragment.hideKeyboard$default(WidgetFriendsAddById.this, null, 1, null);
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppFragment.hideKeyboard$default(WidgetFriendsAddById.this, null, 1, null);
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$sendFriendRequest$1, reason: invalid class name */
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
        public final void call2(Void r8) {
            Context context = WidgetFriendsAddById.this.getContext();
            Context context2 = WidgetFriendsAddById.this.getContext();
            AppToast.h(context, context2 != null ? FormatUtils.h(context2, R.string.add_friend_confirmation, new Object[]{this.$username}, null, 4) : null, 0, null, 12);
            TextInputLayout textInputLayout = WidgetFriendsAddById.access$getBinding$p(WidgetFriendsAddById.this).e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
            ViewExtensions.clear(textInputLayout);
            AppFragment.hideKeyboard$default(WidgetFriendsAddById.this, null, 1, null);
        }
    }

    /* compiled from: WidgetFriendsAddById.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "error", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$sendFriendRequest$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public final /* synthetic */ int $discriminator;
        public final /* synthetic */ String $username;

        /* compiled from: WidgetFriendsAddById.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$sendFriendRequest$2$1, reason: invalid class name */
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
                    WidgetFriendsAddById widgetFriendsAddById = WidgetFriendsAddById.this;
                    Error error2 = this.$error;
                    Intrinsics3.checkNotNullExpressionValue(error2, "error");
                    WidgetFriendsAddById.access$launchCaptchaFlow(widgetFriendsAddById, error2);
                    return;
                }
                WidgetFriendsAddById.access$getBinding$p(WidgetFriendsAddById.this).e.setErrorTextAppearance(2131952238);
                RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                Context context = WidgetFriendsAddById.this.getContext();
                Error error3 = this.$error;
                Intrinsics3.checkNotNullExpressionValue(error3, "error");
                Error.Response response = error3.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                WidgetFriendsAddById.access$setInputEditError(WidgetFriendsAddById.this, String.valueOf(responseResolver.getRelationshipResponse(context, response.getCode(), AnonymousClass2.this.$username + UserUtils.INSTANCE.padDiscriminator(AnonymousClass2.this.$discriminator))));
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

    public WidgetFriendsAddById() {
        super(R.layout.widget_friends_add_by_id);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFriendsAddById2.INSTANCE, null, 2, null);
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetFriendsAddById3(this));
    }

    public static final /* synthetic */ void access$extractTargetAndSendFriendRequest(WidgetFriendsAddById widgetFriendsAddById, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetFriendsAddById.extractTargetAndSendFriendRequest(captchaPayload);
    }

    public static final /* synthetic */ WidgetFriendsAddByIdBinding access$getBinding$p(WidgetFriendsAddById widgetFriendsAddById) {
        return widgetFriendsAddById.getBinding();
    }

    public static final /* synthetic */ Regex access$getPATTERN_USERNAME$cp() {
        return PATTERN_USERNAME;
    }

    public static final /* synthetic */ void access$launchCaptchaFlow(WidgetFriendsAddById widgetFriendsAddById, Error error) {
        widgetFriendsAddById.launchCaptchaFlow(error);
    }

    public static final /* synthetic */ void access$setInputEditError(WidgetFriendsAddById widgetFriendsAddById, CharSequence charSequence) {
        widgetFriendsAddById.setInputEditError(charSequence);
    }

    private final void extractTargetAndSendFriendRequest(CaptchaHelper.CaptchaPayload captchaPayload) {
        TextInputLayout textInputLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        Companion.UserNameDiscriminator userNameDiscriminatorAccess$extractUsernameAndDiscriminator = Companion.access$extractUsernameAndDiscriminator(INSTANCE, textOrEmpty);
        if (userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator() != null) {
            sendFriendRequest(userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername(), userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator().intValue(), captchaPayload);
            return;
        }
        Context context = getContext();
        setInputEditError(context != null ? FormatUtils.h(context, R.string.add_friend_error_username_only, new Object[]{userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername()}, null, 4) : null);
        AnalyticsTracker.INSTANCE.friendRequestFailed(textOrEmpty, userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername(), userNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator(), "Invalid Username");
    }

    public static /* synthetic */ void extractTargetAndSendFriendRequest$default(WidgetFriendsAddById widgetFriendsAddById, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetFriendsAddById.extractTargetAndSendFriendRequest(captchaPayload);
    }

    private final WidgetFriendsAddByIdBinding getBinding() {
        return (WidgetFriendsAddByIdBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SpannableStringBuilder getUsernameIndicatorText(User user) {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        UserUtils userUtils = UserUtils.INSTANCE;
        CharSequence charSequenceI = FormatUtils.i(resources, R.string.self_username_indicator, new Object[]{UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null)}, null, 4);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequenceI);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) charSequenceI;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ColorCompat.getThemedColor(requireContext(), R.attr.colorHeaderPrimary)), spannableStringBuilder2.length() - UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null).length(), spannableStringBuilder2.length(), 33);
        return spannableStringBuilder;
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.INSTANCE.launch(requireContext(), this.captchaLauncher, CaptchaErrorBody.INSTANCE.createFromError(error));
    }

    private final void sendFriendRequest(String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().sendRelationshipRequest("Search - Add Friend Search", username, discriminator, captchaPayload), this, null, 2, null).k(o.h(new AnonymousClass1(username), getAppActivity(), new AnonymousClass2(username, discriminator)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetFriendsAddById widgetFriendsAddById, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaPayload = null;
        }
        widgetFriendsAddById.sendFriendRequest(str, i, captchaPayload);
    }

    private final void setInputEditError(CharSequence error) {
        TextInputLayout textInputLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        textInputLayout.setError(error);
        TextInputLayout textInputLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        textInputLayout2.setErrorEnabled(!(error == null || StringsJVM.isBlank(error)));
    }

    private final void setInputText(String text) {
        if (text == null || StringsJVM.isBlank(text)) {
            return;
        }
        TextInputLayout textInputLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        ViewExtensions.setText(textInputLayout, text);
        TextInputLayout textInputLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        ViewExtensions.setSelectionEnd(textInputLayout2);
    }

    @Override // com.discord.app.AppFragment
    public void hideKeyboard(View view) {
        super.hideKeyboard(view);
        getBinding().e.clearFocus();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppFragment.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AnalyticsTracker.INSTANCE.friendAddViewed("Id");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        TextInputLayout textInputLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        TextInputLayout textInputLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new AnonymousClass3(), 1, null);
        getBinding().c.setOnClickListener(new AnonymousClass4());
        Bundle extras = getMostRecentIntent().getExtras();
        setInputText(extras != null ? extras.getString("android.intent.extra.TEXT") : null);
        MeUser meSnapshot = StoreStream.INSTANCE.getUsers().getMeSnapshot();
        TextView textView = getBinding().f2391b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendAddUsernameIndicator");
        textView.setVisibility(0);
        TextView textView2 = getBinding().f2391b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.friendAddUsernameIndicator");
        textView2.setText(getUsernameIndicatorText(meSnapshot));
    }
}
