package com.discord.widgets.auth;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModel;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.OauthTokenPermissionDetailedListItemBinding;
import com.discord.databinding.WidgetOauthAuthorizeBinding;
import com.discord.i18n.RenderContext;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.OAuthPermissionViews;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.Tuples;
import d0.c0.Random;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetOauth2Authorize.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 G2\u00020\u0001:\u0005GHIJKB\u0007¢\u0006\u0004\bF\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020)8D@\u0004X\u0084\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00104\u001a\u00020/8D@\u0004X\u0084\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00108\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010>\u001a\u00020:8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010+\u001a\u0004\b<\u0010=R(\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?8\u0014@\u0014X\u0094\u0004¢\u0006\u0012\n\u0004\bA\u0010B\u0012\u0004\bE\u0010$\u001a\u0004\bC\u0010D¨\u0006L"}, d2 = {"Lcom/discord/widgets/auth/WidgetOauth2Authorize;", "Lcom/discord/app/AppFragment;", "Lcom/discord/views/OAuthPermissionViews$InvalidScopeException;", "e", "", "onUnknownScope", "(Lcom/discord/views/OAuthPermissionViews$InvalidScopeException;)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "configureNotSupportedUI", "(Landroid/net/Uri;)V", "", "clientId", "configureAgeNoticeUI", "(J)V", "", "", "scopeNames", "configureSecurityNoticeUI", "(Ljava/util/List;)V", "", "getRandomFakeScopeText", "()I", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "authorizeApplication", "(Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "requestUrl", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "createOauthAuthorize", "(Landroid/net/Uri;)Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "onViewBoundOrOnResume", "()V", "Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;", "data", "configureUI", "(Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;)V", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2ViewModel;", "oauth2ViewModel$delegate", "Lkotlin/Lazy;", "getOauth2ViewModel", "()Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2ViewModel;", "oauth2ViewModel", "Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", "binding", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$PermissionModel;", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuthPermissionViewHolder;", "adapter", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "captchaLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "getCaptchaLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "getCaptchaLauncher$annotations", "<init>", "Companion", "OAuth2Authorize", "OAuth2ViewModel", "OAuthPermissionViewHolder", "PermissionModel", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class WidgetOauth2Authorize extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetOauth2Authorize.class, "binding", "getBinding()Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_PARAM_URI = "REQ_URI";
    private static final String QUERY_INTERNAL_REFERRER = "internal_referrer";
    private static final String QUERY_PARAM_CLIENT_ID = "client_id";
    private static final String QUERY_PARAM_CODE_CHALLENGE = "code_challenge";
    private static final String QUERY_PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
    private static final String QUERY_PARAM_PERMISSIONS = "permissions";
    private static final String QUERY_PARAM_REDIRECT = "redirect_uri";
    private static final String QUERY_PARAM_RESPONSE_TYPE = "response_type";
    private static final String QUERY_PARAM_SCOPE = "scope";
    private static final String QUERY_PARAM_STATE = "state";
    private static final String ROOT_ERROR_KEY = "_root";
    private final SimpleRecyclerAdapter<PermissionModel, OAuthPermissionViewHolder> adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* renamed from: oauth2ViewModel$delegate, reason: from kotlin metadata */
    private final Lazy oauth2ViewModel;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0016\u0010$\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010%\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0016\u0010&\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0016\u0010'\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u001eR\u0016\u0010(\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u001e¨\u0006+"}, d2 = {"Lcom/discord/widgets/auth/WidgetOauth2Authorize$Companion;", "", "Landroid/net/Uri;", "requestUri", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "oAuth2Authorize", "Landroid/content/Intent;", "createLaunchIntent", "(Landroid/net/Uri;Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;)Landroid/content/Intent;", "requestUrl", "createOauthAuthorize", "(Landroid/net/Uri;)Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "Landroid/content/Context;", "context", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Lkotlin/Function0;", "", "onComplete", "handleError", "(Landroid/content/Context;Ljava/lang/Exception;Lkotlin/jvm/functions/Function0;)V", "", "clientId", "", "getNoticeName", "(J)Ljava/lang/String;", "launch", "(Landroid/content/Context;Landroid/net/Uri;)V", "INTENT_PARAM_URI", "Ljava/lang/String;", "QUERY_INTERNAL_REFERRER", "QUERY_PARAM_CLIENT_ID", "QUERY_PARAM_CODE_CHALLENGE", "QUERY_PARAM_CODE_CHALLENGE_METHOD", "QUERY_PARAM_PERMISSIONS", "QUERY_PARAM_REDIRECT", "QUERY_PARAM_RESPONSE_TYPE", "QUERY_PARAM_SCOPE", "QUERY_PARAM_STATE", "ROOT_ERROR_KEY", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ OAuth2Authorize access$createOauthAuthorize(Companion companion, Uri uri) {
            return companion.createOauthAuthorize(uri);
        }

        public static final /* synthetic */ void access$handleError(Companion companion, Context context, Exception exc, Function0 function0) {
            companion.handleError(context, exc, function0);
        }

        private final Intent createLaunchIntent(Uri requestUri, OAuth2Authorize oAuth2Authorize) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra(WidgetOauth2Authorize.INTENT_PARAM_URI, requestUri);
            String internalReferrer = oAuth2Authorize.getInternalReferrer();
            if ((internalReferrer == null || !Boolean.parseBoolean(internalReferrer)) && !oAuth2Authorize.isUnsupported()) {
                intent.addFlags(268468224);
            }
            return intent;
        }

        private final OAuth2Authorize createOauthAuthorize(Uri requestUrl) throws NumberFormatException {
            WidgetOauth2Authorize3 widgetOauth2Authorize3 = WidgetOauth2Authorize3.INSTANCE;
            long j = Long.parseLong(widgetOauth2Authorize3.invoke2(requestUrl, WidgetOauth2Authorize.QUERY_PARAM_CLIENT_ID));
            String queryParameter = requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_REDIRECT);
            return new OAuth2Authorize(j, requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_STATE), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_RESPONSE_TYPE), queryParameter, null, widgetOauth2Authorize3.invoke2(requestUrl, WidgetOauth2Authorize.QUERY_PARAM_SCOPE), requestUrl.getQueryParameter("permissions"), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_CODE_CHALLENGE), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_CODE_CHALLENGE_METHOD), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_INTERNAL_REFERRER), 16, null);
        }

        private final void handleError(Context context, Exception e, Function0<Unit> onComplete) {
            String string = FormatUtils.h(context, R.string.oauth2_request_missing_param, new Object[]{e.getMessage()}, null, 4).toString();
            AppLog.g.w(string, e);
            AppToast.h(context, string, 1, null, 8);
            onComplete.invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleError$default(Companion companion, Context context, Exception exc, Function0 function0, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = WidgetOauth2Authorize4.INSTANCE;
            }
            companion.handleError(context, exc, function0);
        }

        public final String getNoticeName(long clientId) {
            return outline.t("OAUTH_REQUEST:", clientId);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void launch(Context context, Uri requestUri) {
            OAuth2Authorize oAuth2AuthorizeCreateOauthAuthorize;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(requestUri, "requestUri");
            try {
                oAuth2AuthorizeCreateOauthAuthorize = createOauthAuthorize(requestUri);
            } catch (Exception e) {
                handleError$default(this, context, e, null, 4, null);
                oAuth2AuthorizeCreateOauthAuthorize = null;
            }
            if (oAuth2AuthorizeCreateOauthAuthorize != null) {
                long clientId = oAuth2AuthorizeCreateOauthAuthorize.getClientId();
                AnalyticsTracker.INSTANCE.oauth2AuthorizedViewed(clientId);
                boolean z2 = true;
                if (Intrinsics3.areEqual(String.valueOf(clientId), "591317049637339146")) {
                    if (!(Build.VERSION.SDK_INT >= 28 && StringsJVM.equals(Build.MANUFACTURER, "samsung", true))) {
                    }
                } else {
                    z2 = false;
                }
                AppScreen2.d(context, z2 ? WidgetOauth2AuthorizeSamsung.class : WidgetOauth2Authorize.class, createLaunchIntent(requestUri, oAuth2AuthorizeCreateOauthAuthorize));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b=\u0010>J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0010J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0010J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0010J\u0082\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b%\u0010\u0010J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010-\u001a\u0004\b.\u0010\u0010R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b/\u0010\u0010R\u0016\u00102\u001a\u00020*8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001b\u0010 \u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b3\u0010\u0010R\u0019\u0010\u001e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b4\u0010\u0010R\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\b6\u0010\u000eR\u0013\u00107\u001a\u00020*8F@\u0006¢\u0006\u0006\u001a\u0004\b7\u00101R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b8\u0010\u0010R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b9\u0010\u0010R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b:\u0010\u0010R\u001b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b;\u0010\u0010R\u0019\u0010\u001d\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b<\u0010\u0010¨\u0006?"}, d2 = {"Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "", "Lrx/Observable;", "Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;", "get", "()Lrx/Observable;", "", "captchaKey", "captchaRqtoken", "Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponsePost;", "post", "(Ljava/lang/String;Ljava/lang/String;)Lrx/Observable;", "", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "clientId", WidgetOauth2Authorize.QUERY_PARAM_STATE, "responseType", "redirectUrl", "prompt", WidgetOauth2Authorize.QUERY_PARAM_SCOPE, "permissions", "codeChallenge", "codeChallengeMethod", "internalReferrer", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getInternalReferrer", "getState", "getHasBotPermission", "()Z", "hasBotPermission", "getCodeChallenge", "getScope", "J", "getClientId", "isUnsupported", "getPermissions", "getResponseType", "getRedirectUrl", "getCodeChallengeMethod", "getPrompt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class OAuth2Authorize {
        private final long clientId;
        private final String codeChallenge;
        private final String codeChallengeMethod;
        private final String internalReferrer;
        private final String permissions;
        private final String prompt;
        private final String redirectUrl;
        private final String responseType;
        private final String scope;
        private final String state;

        public OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            Intrinsics3.checkNotNullParameter(str4, "prompt");
            Intrinsics3.checkNotNullParameter(str5, WidgetOauth2Authorize.QUERY_PARAM_SCOPE);
            this.clientId = j;
            this.state = str;
            this.responseType = str2;
            this.redirectUrl = str3;
            this.prompt = str4;
            this.scope = str5;
            this.permissions = str6;
            this.codeChallenge = str7;
            this.codeChallengeMethod = str8;
            this.internalReferrer = str9;
        }

        public static /* synthetic */ OAuth2Authorize copy$default(OAuth2Authorize oAuth2Authorize, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
            return oAuth2Authorize.copy((i & 1) != 0 ? oAuth2Authorize.clientId : j, (i & 2) != 0 ? oAuth2Authorize.state : str, (i & 4) != 0 ? oAuth2Authorize.responseType : str2, (i & 8) != 0 ? oAuth2Authorize.redirectUrl : str3, (i & 16) != 0 ? oAuth2Authorize.prompt : str4, (i & 32) != 0 ? oAuth2Authorize.scope : str5, (i & 64) != 0 ? oAuth2Authorize.permissions : str6, (i & 128) != 0 ? oAuth2Authorize.codeChallenge : str7, (i & 256) != 0 ? oAuth2Authorize.codeChallengeMethod : str8, (i & 512) != 0 ? oAuth2Authorize.internalReferrer : str9);
        }

        private final boolean getHasBotPermission() {
            List<String> listSplit$default = Strings4.split$default((CharSequence) this.scope, new String[]{" "}, false, 0, 6, (Object) null);
            if ((listSplit$default instanceof Collection) && listSplit$default.isEmpty()) {
                return false;
            }
            for (String str : listSplit$default) {
                if (StringsJVM.equals(str, OAuthScope.Bot.INSTANCE.getScopeName(), true) || StringsJVM.equals(str, OAuthScope.WebhookIncoming.INSTANCE.getScopeName(), true)) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ Observable post$default(OAuth2Authorize oAuth2Authorize, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return oAuth2Authorize.post(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getClientId() {
            return this.clientId;
        }

        /* renamed from: component10, reason: from getter */
        public final String getInternalReferrer() {
            return this.internalReferrer;
        }

        /* renamed from: component2, reason: from getter */
        public final String getState() {
            return this.state;
        }

        /* renamed from: component3, reason: from getter */
        public final String getResponseType() {
            return this.responseType;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        /* renamed from: component5, reason: from getter */
        public final String getPrompt() {
            return this.prompt;
        }

        /* renamed from: component6, reason: from getter */
        public final String getScope() {
            return this.scope;
        }

        /* renamed from: component7, reason: from getter */
        public final String getPermissions() {
            return this.permissions;
        }

        /* renamed from: component8, reason: from getter */
        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        /* renamed from: component9, reason: from getter */
        public final String getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        public final OAuth2Authorize copy(long clientId, String state, String responseType, String redirectUrl, String prompt, String scope, String permissions, String codeChallenge, String codeChallengeMethod, String internalReferrer) {
            Intrinsics3.checkNotNullParameter(prompt, "prompt");
            Intrinsics3.checkNotNullParameter(scope, WidgetOauth2Authorize.QUERY_PARAM_SCOPE);
            return new OAuth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions, codeChallenge, codeChallengeMethod, internalReferrer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuth2Authorize)) {
                return false;
            }
            OAuth2Authorize oAuth2Authorize = (OAuth2Authorize) other;
            return this.clientId == oAuth2Authorize.clientId && Intrinsics3.areEqual(this.state, oAuth2Authorize.state) && Intrinsics3.areEqual(this.responseType, oAuth2Authorize.responseType) && Intrinsics3.areEqual(this.redirectUrl, oAuth2Authorize.redirectUrl) && Intrinsics3.areEqual(this.prompt, oAuth2Authorize.prompt) && Intrinsics3.areEqual(this.scope, oAuth2Authorize.scope) && Intrinsics3.areEqual(this.permissions, oAuth2Authorize.permissions) && Intrinsics3.areEqual(this.codeChallenge, oAuth2Authorize.codeChallenge) && Intrinsics3.areEqual(this.codeChallengeMethod, oAuth2Authorize.codeChallengeMethod) && Intrinsics3.areEqual(this.internalReferrer, oAuth2Authorize.internalReferrer);
        }

        public final Observable<RestAPIParams.OAuth2Authorize.ResponseGet> get() {
            return RestAPI.INSTANCE.getApi().getOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions);
        }

        public final long getClientId() {
            return this.clientId;
        }

        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        public final String getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        public final String getInternalReferrer() {
            return this.internalReferrer;
        }

        public final String getPermissions() {
            return this.permissions;
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        public final String getResponseType() {
            return this.responseType;
        }

        public final String getScope() {
            return this.scope;
        }

        public final String getState() {
            return this.state;
        }

        public int hashCode() {
            int iA = b.a(this.clientId) * 31;
            String str = this.state;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.responseType;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.redirectUrl;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.prompt;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.scope;
            int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.permissions;
            int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.codeChallenge;
            int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.codeChallengeMethod;
            int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.internalReferrer;
            return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
        }

        public final boolean isUnsupported() {
            return getHasBotPermission();
        }

        public final Observable<RestAPIParams.OAuth2Authorize.ResponsePost> post(String captchaKey, String captchaRqtoken) {
            return RestAPI.INSTANCE.getApi().postOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions, this.codeChallenge, this.codeChallengeMethod, Maps6.plus(Maps6.plus(MapsJVM.mapOf(Tuples.to("authorize", "true")), captchaKey != null ? MapsJVM.mapOf(Tuples.to(CaptchaHelper.CAPTCHA_KEY, captchaKey)) : Maps6.emptyMap()), captchaRqtoken != null ? MapsJVM.mapOf(Tuples.to("captcha_rqtoken", captchaRqtoken)) : Maps6.emptyMap()));
        }

        public String toString() {
            StringBuilder sbU = outline.U("OAuth2Authorize(clientId=");
            sbU.append(this.clientId);
            sbU.append(", state=");
            sbU.append(this.state);
            sbU.append(", responseType=");
            sbU.append(this.responseType);
            sbU.append(", redirectUrl=");
            sbU.append(this.redirectUrl);
            sbU.append(", prompt=");
            sbU.append(this.prompt);
            sbU.append(", scope=");
            sbU.append(this.scope);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", codeChallenge=");
            sbU.append(this.codeChallenge);
            sbU.append(", codeChallengeMethod=");
            sbU.append(this.codeChallengeMethod);
            sbU.append(", internalReferrer=");
            return outline.J(sbU, this.internalReferrer, ")");
        }

        public /* synthetic */ OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? "consent" : str4, str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9);
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2ViewModel;", "Lb/a/d/d0;", "", "Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;", "oauthGetResponse", "Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;", "getOauthGetResponse", "()Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;", "setOauthGetResponse", "(Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;)V", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "oauthAuthorize", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "getOauthAuthorize", "()Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "setOauthAuthorize", "(Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class OAuth2ViewModel extends AppViewModel<Unit> {
        public OAuth2Authorize oauthAuthorize;
        private RestAPIParams.OAuth2Authorize.ResponseGet oauthGetResponse;

        public OAuth2ViewModel() {
            super(null, 1, null);
        }

        public final OAuth2Authorize getOauthAuthorize() {
            OAuth2Authorize oAuth2Authorize = this.oauthAuthorize;
            if (oAuth2Authorize == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("oauthAuthorize");
            }
            return oAuth2Authorize;
        }

        public final RestAPIParams.OAuth2Authorize.ResponseGet getOauthGetResponse() {
            return this.oauthGetResponse;
        }

        public final void setOauthAuthorize(OAuth2Authorize oAuth2Authorize) {
            Intrinsics3.checkNotNullParameter(oAuth2Authorize, "<set-?>");
            this.oauthAuthorize = oAuth2Authorize;
        }

        public final void setOauthGetResponse(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            this.oauthGetResponse = responseGet;
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuthPermissionViewHolder;", "Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$PermissionModel;", "data", "", "bind", "(Lcom/discord/widgets/auth/WidgetOauth2Authorize$PermissionModel;)V", "Lcom/discord/databinding/OauthTokenPermissionDetailedListItemBinding;", "binding", "Lcom/discord/databinding/OauthTokenPermissionDetailedListItemBinding;", "<init>", "(Lcom/discord/databinding/OauthTokenPermissionDetailedListItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class OAuthPermissionViewHolder extends SimpleRecyclerAdapter.ViewHolder<PermissionModel> {
        private final OauthTokenPermissionDetailedListItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public OAuthPermissionViewHolder(OauthTokenPermissionDetailedListItemBinding oauthTokenPermissionDetailedListItemBinding) {
            Intrinsics3.checkNotNullParameter(oauthTokenPermissionDetailedListItemBinding, "binding");
            ConstraintLayout constraintLayout = oauthTokenPermissionDetailedListItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout);
            this.binding = oauthTokenPermissionDetailedListItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(PermissionModel permissionModel) throws OAuthPermissionViews.InvalidScopeException {
            bind2(permissionModel);
        }

        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(PermissionModel data) throws OAuthPermissionViews.InvalidScopeException {
            Intrinsics3.checkNotNullParameter(data, "data");
            if (data.getScope() != null) {
                this.binding.f2133b.setImageResource(R.drawable.ic_check_circle_green_24dp);
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthTokenPermissionDetailedName");
                OAuthPermissionViews.a(textView, data.getScope());
                return;
            }
            if (data.getFakeText() != null) {
                this.binding.f2133b.setImageResource(R.drawable.ic_close_circle_grey_24dp);
                this.binding.c.setText(data.getFakeText().intValue());
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/auth/WidgetOauth2Authorize$PermissionModel;", "", "", "fakeText", "Ljava/lang/Integer;", "getFakeText", "()Ljava/lang/Integer;", "Lcom/discord/api/auth/OAuthScope;", WidgetOauth2Authorize.QUERY_PARAM_SCOPE, "Lcom/discord/api/auth/OAuthScope;", "getScope", "()Lcom/discord/api/auth/OAuthScope;", "<init>", "(Lcom/discord/api/auth/OAuthScope;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PermissionModel {
        private final Integer fakeText;
        private final OAuthScope scope;

        public PermissionModel(OAuthScope oAuthScope, Integer num) {
            this.scope = oAuthScope;
            this.fakeText = num;
        }

        public final Integer getFakeText() {
            return this.fakeText;
        }

        public final OAuthScope getScope() {
            return this.scope;
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$authorizeApplication$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
            Context contextRequireContext = WidgetOauth2Authorize.this.requireContext();
            ActivityResultLauncher<Intent> captchaLauncher = WidgetOauth2Authorize.this.getCaptchaLauncher();
            ValidationManager validationManagerAccess$getValidationManager$p = WidgetOauth2Authorize.access$getValidationManager$p(WidgetOauth2Authorize.this);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
            companion.processErrorsForCaptcha(contextRequireContext, captchaLauncher, _Collections.toMutableList((Collection) validationManagerAccess$getValidationManager$p.setErrors(messages)), error);
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponsePost;", "it", "", "invoke", "(Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponsePost;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$authorizeApplication$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestAPIParams.OAuth2Authorize.ResponsePost, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) throws Exception {
            invoke2(responsePost);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) throws Exception {
            Intrinsics3.checkNotNullParameter(responsePost, "it");
            Uri uri = Uri.parse(responsePost.getLocation());
            Logger.d$default(AppLog.g, "Redirect OAuth flow to: " + uri, null, 2, null);
            Intent intentAddFlags = new Intent("android.intent.action.VIEW", uri).addFlags(268435456);
            Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent(Intent.ACTION_VIE…t.FLAG_ACTIVITY_NEW_TASK)");
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.startActivity(intentAddFlags);
            }
            AppActivity appActivity2 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.setResult(-1);
            }
            AppActivity appActivity3 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity3 != null) {
                appActivity3.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$configureNotSupportedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Uri $uri;

        public AnonymousClass1(Uri uri) {
            this.$uri = uri;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws Exception {
            AppToast.c(outline.x(view, "it", "it.context"), String.valueOf(this.$uri), 0, 4);
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$configureSecurityNoticeUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetOauth2Authorize.this.requireContext(), R.attr.colorHeaderPrimary));
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetOauth2Authorize.access$authorizeApplication(WidgetOauth2Authorize.this, null);
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.setResult(0);
            }
            AppActivity appActivity2 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.finish();
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3<R> implements Func0<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.finishAndRemoveTask();
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            Intrinsics3.checkNotNullExpressionValue(messages, "it");
            if (!(!messages.isEmpty())) {
                messages = null;
            }
            if (messages == null) {
                Error.Response response2 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
                messages = MapsJVM.mapOf(Tuples.to(WidgetOauth2Authorize.ROOT_ERROR_KEY, CollectionsJVM.listOf(response2.getMessage())));
            }
            error.setShowErrorToasts(!WidgetOauth2Authorize.access$getValidationManager$p(WidgetOauth2Authorize.this).setErrors(messages).isEmpty());
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;", "response", "", "invoke", "(Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestAPIParams.OAuth2Authorize.ResponseGet, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            invoke2(responseGet);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            Intrinsics3.checkNotNullParameter(responseGet, "response");
            WidgetOauth2Authorize.this.getOauth2ViewModel().setOauthGetResponse(responseGet);
            WidgetOauth2Authorize.this.configureUI(responseGet);
        }
    }

    public WidgetOauth2Authorize() {
        super(R.layout.widget_oauth_authorize);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetOauth2Authorize6.INSTANCE, null, 2, null);
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetOauth2Authorize7(this));
        WidgetOauth2Authorize8 widgetOauth2Authorize8 = WidgetOauth2Authorize8.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.oauth2ViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(OAuth2ViewModel.class), new WidgetOauth2Authorize$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetOauth2Authorize8));
        this.validationManager = LazyJVM.lazy(new WidgetOauth2Authorize9(this));
        this.adapter = new SimpleRecyclerAdapter<>(null, WidgetOauth2Authorize5.INSTANCE, 1, null);
    }

    public static final /* synthetic */ void access$authorizeApplication(WidgetOauth2Authorize widgetOauth2Authorize, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetOauth2Authorize.authorizeApplication(captchaPayload);
    }

    public static final /* synthetic */ ValidationManager access$getValidationManager$p(WidgetOauth2Authorize widgetOauth2Authorize) {
        return widgetOauth2Authorize.getValidationManager();
    }

    private final void authorizeApplication(CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), getClass(), (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    private final void configureAgeNoticeUI(long clientId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(clientId));
        TextView textView = getBinding().f2506b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeAgeNotice");
        FormatUtils.n(textView, R.string.oauth2_details_creation_date, new Object[]{DateUtils.formatDateTime(requireContext(), snowflake, 65536)}, null, 4);
    }

    private final void configureNotSupportedUI(Uri uri) {
        LinearLayout linearLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(8);
        getBinding().n.setOnClickListener(new AnonymousClass1(uri));
    }

    private final void configureSecurityNoticeUI(List<String> scopeNames) {
        int i = scopeNames.contains(OAuthScope.MessagesRead.INSTANCE.getScopeName()) ? R.string.oauth2_can_read_notice : R.string.oauth2_cannot_read_send_notice;
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeSecurityNotice");
        FormatUtils.m(textView, i, new Object[0], new AnonymousClass1());
    }

    public static /* synthetic */ void getCaptchaLauncher$annotations() {
    }

    private final int getRandomFakeScopeText() {
        switch (Random.k.nextInt(8)) {
            case 0:
                return R.string.oauth2_fake_scope_1;
            case 1:
                return R.string.oauth2_fake_scope_2;
            case 2:
                return R.string.oauth2_fake_scope_3;
            case 3:
                return R.string.oauth2_fake_scope_4;
            case 4:
                return R.string.oauth2_fake_scope_5;
            case 5:
                return R.string.oauth2_fake_scope_6;
            case 6:
                return R.string.oauth2_fake_scope_7;
            default:
                return R.string.oauth2_fake_scope_8;
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void onUnknownScope(OAuthPermissionViews.InvalidScopeException e) {
        AppLog appLog = AppLog.g;
        StringBuilder sbU = outline.U("invalid scope ");
        sbU.append(e.getScope());
        sbU.append(" in ");
        sbU.append(getClass().getSimpleName());
        Logger.e$default(appLog, sbU.toString(), e, null, 4, null);
        AppToast.h(requireContext(), FormatUtils.h(requireContext(), R.string.oauth2_request_invalid_scope, new Object[]{e.getScope()}, null, 4), 1, null, 8);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(0);
            appActivity.finish();
        }
    }

    public void configureUI(RestAPIParams.OAuth2Authorize.ResponseGet data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        LinearLayout linearLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(0);
        User user = data.getUser();
        SimpleDraweeView simpleDraweeView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.oauthAuthorizeUserIcon");
        Long lValueOf = Long.valueOf(user.getId());
        NullSerializable<String> nullSerializableA = user.a();
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForUser$default(lValueOf, nullSerializableA != null ? nullSerializableA.a() : null, null, false, null, 28, null), 0, 0, false, null, null, 124, null);
        Application application = data.getApplication();
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeApplicationName");
        textView.setText(application.getName());
        TextView textView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.oauthAuthorizePermissionsLabelTv");
        FormatUtils.n(textView2, R.string.oauth2_scopes_label, new Object[]{application.getName()}, null, 4);
        SimpleDraweeView simpleDraweeView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.oauthAuthorizeApplicationIcon");
        String icon = application.getIcon();
        MGImages.setImage$default(simpleDraweeView2, icon != null ? IconUtils.getApplicationIcon$default(application.getId(), icon, 0, 4, (Object) null) : null, 0, 0, false, null, null, 124, null);
        try {
            List listSplit$default = Strings4.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null);
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            for (String str : arrayList) {
                Objects.requireNonNull(OAuthScopeTypeAdapter.INSTANCE);
                arrayList2.add(new PermissionModel((OAuthScope) OAuthScopeTypeAdapter.a().get(str), null));
            }
            List mutableList = _Collections.toMutableList((Collection) arrayList2);
            this.adapter.setData(_Collections.plus((Collection) mutableList, (Iterable) (mutableList.isEmpty() ^ true ? CollectionsJVM.listOf(new PermissionModel(null, Integer.valueOf(getRandomFakeScopeText()))) : Collections2.emptyList())));
            getBinding().g.setOnClickListener(new AnonymousClass3());
        } catch (OAuthPermissionViews.InvalidScopeException e) {
            onUnknownScope(e);
        }
    }

    public OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        Intrinsics3.checkNotNullParameter(requestUrl, "requestUrl");
        return Companion.access$createOauthAuthorize(INSTANCE, requestUrl);
    }

    public final WidgetOauthAuthorizeBinding getBinding() {
        return (WidgetOauthAuthorizeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public ActivityResultLauncher<Intent> getCaptchaLauncher() {
        return this.captchaLauncher;
    }

    public final OAuth2ViewModel getOauth2ViewModel() {
        return (OAuth2ViewModel) this.oauth2ViewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.oauthAuthorizePermissionsList");
        recyclerView.setAdapter(this.adapter);
        Uri uri = (Uri) getMostRecentIntent().getParcelableExtra(INTENT_PARAM_URI);
        if (uri == null) {
            uri = Uri.EMPTY;
        }
        try {
            OAuth2ViewModel oauth2ViewModel = getOauth2ViewModel();
            Intrinsics3.checkNotNullExpressionValue(uri, "requestUrl");
            oauth2ViewModel.setOauthAuthorize(createOauthAuthorize(uri));
            Iterator it = Collections2.listOf((Object[]) new MaterialButton[]{getBinding().f, getBinding().i, getBinding().o}).iterator();
            while (it.hasNext()) {
                ((MaterialButton) it.next()).setOnClickListener(new WidgetOauth2Authorize2(this));
            }
            AppFragment.setOnBackPressed$default(this, new AnonymousClass3(), 0, 2, null);
            configureAgeNoticeUI(getOauth2ViewModel().getOauthAuthorize().getClientId());
            configureSecurityNoticeUI(Strings4.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null));
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), INSTANCE.getNoticeName(getOauth2ViewModel().getOauthAuthorize().getClientId()), 0L, 2, null);
        } catch (IllegalArgumentException e) {
            Companion.access$handleError(INSTANCE, requireContext(), e, new AnonymousClass1());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || !appActivity.isFinishing()) {
            if (getOauth2ViewModel().getOauthAuthorize().isUnsupported()) {
                Uri uri = (Uri) getMostRecentIntent().getParcelableExtra(INTENT_PARAM_URI);
                if (uri == null) {
                    uri = Uri.EMPTY;
                }
                Intrinsics3.checkNotNullExpressionValue(uri, "requestUrl");
                configureNotSupportedUI(uri);
                return;
            }
            RestAPIParams.OAuth2Authorize.ResponseGet oauthGetResponse = getOauth2ViewModel().getOauthGetResponse();
            if (oauthGetResponse != null) {
                configureUI(oauthGetResponse);
                return;
            }
            LinearLayout linearLayout = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeContent");
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeLoading");
            linearLayout3.setVisibility(0);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().get(), false, 1, null), this, null, 2, null), getClass(), requireContext(), (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 52, (Object) null);
        }
    }
}
