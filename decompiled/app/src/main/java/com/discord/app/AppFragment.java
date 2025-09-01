package com.discord.app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppActivity2;
import b.a.d.AppFragment2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.a.l.MediaPickerChooser2;
import b.b.a.f.SimpleFileManager;
import com.discord.R;
import com.discord.app.AppLogger;
import com.discord.media_picker.MediaPicker;
import com.discord.media_picker.RequestType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.views.ToolbarTitleLayout;
import com.lytefast.flexinput.managers.FileManager;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* compiled from: AppFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\n\b\u0016¢\u0006\u0005\b\u0090\u0001\u0010\u001dB\u0016\b\u0016\u0012\t\b\u0001\u0010\u0091\u0001\u001a\u00020%¢\u0006\u0006\b\u0090\u0001\u0010\u0092\u0001J\u001f\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J-\u0010\u0014\u001a\u00020\t2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J-\u0010\u0017\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0011J+\u0010\u0018\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\n\u0010\u001eJ\u000f\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010#J\u0019\u0010'\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J%\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0001\u0010-\u001a\u0004\u0018\u00010%¢\u0006\u0004\b+\u0010.J/\u0010+\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0001\u0010-\u001a\u0004\u0018\u00010%2\n\b\u0001\u0010/\u001a\u0004\u0018\u00010%¢\u0006\u0004\b+\u00100J\u0019\u0010+\u001a\u0004\u0018\u00010\t2\b\b\u0001\u00101\u001a\u00020%¢\u0006\u0004\b+\u0010(J\u0019\u00103\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010)¢\u0006\u0004\b3\u0010,J\u0019\u00103\u001a\u0004\u0018\u00010\t2\b\b\u0001\u00104\u001a\u00020%¢\u0006\u0004\b3\u0010(J\u0017\u00107\u001a\u0004\u0018\u00010\t2\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b9\u0010#JC\u0010C\u001a\u0004\u0018\u00010B2\b\b\u0001\u0010:\u001a\u00020%2\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0018\u00010;2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0007¢\u0006\u0004\bC\u0010DJ\u001b\u0010F\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010E\u001a\u00020\u0019H\u0007¢\u0006\u0004\bF\u0010GJ1\u0010F\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010E\u001a\u00020\u00192\n\b\u0001\u0010H\u001a\u0004\u0018\u00010%2\n\b\u0001\u0010I\u001a\u0004\u0018\u00010%¢\u0006\u0004\bF\u0010JJ!\u0010N\u001a\u00020\t2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\t0K¢\u0006\u0004\bN\u0010OJ!\u0010R\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\tH\u0017¢\u0006\u0004\bV\u0010\u001dJ\u000f\u0010W\u001a\u00020\tH\u0016¢\u0006\u0004\bW\u0010\u001dJ\u000f\u0010X\u001a\u00020\tH\u0016¢\u0006\u0004\bX\u0010\u001dJ\u000f\u0010Y\u001a\u00020\tH\u0016¢\u0006\u0004\bY\u0010\u001dJ\u000f\u0010Z\u001a\u00020\tH\u0016¢\u0006\u0004\bZ\u0010\u001dJ)\u0010^\u001a\u00020\t2\u0006\u0010[\u001a\u00020%2\u0006\u0010\\\u001a\u00020%2\b\u0010]\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\b^\u0010_J\u000f\u0010a\u001a\u00020`H\u0016¢\u0006\u0004\ba\u0010bJ\u001f\u0010g\u001a\u00020\t2\u0006\u0010d\u001a\u00020c2\u0006\u0010f\u001a\u00020eH\u0016¢\u0006\u0004\bg\u0010hJ\u001f\u0010i\u001a\u00020\t2\u0006\u0010d\u001a\u00020c2\u0006\u0010f\u001a\u00020eH\u0016¢\u0006\u0004\bi\u0010hJ'\u0010m\u001a\u00020\t2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00190j2\b\b\u0002\u0010l\u001a\u00020%H\u0007¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bo\u0010UJ\u001b\u0010p\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\bp\u0010UR\u0015\u0010r\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\bq\u0010\rR\u001e\u0010t\u001a\u0004\u0018\u00010s8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u001d\u0010}\u001a\u00020x8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u0014\u0010\u0080\u0001\u001a\u00020L8F@\u0006¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0019\u0010\u0081\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R)\u0010\u0084\u0001\u001a\u00020\u00192\u0007\u0010\u0083\u0001\u001a\u00020\u00198\u0004@BX\u0084\u000e¢\u0006\u000f\n\u0006\b\u0084\u0001\u0010\u0082\u0001\u001a\u0005\b\u0084\u0001\u0010\u001bR\"\u0010\u0089\u0001\u001a\u00030\u0085\u00018F@\u0006X\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0086\u0001\u0010z\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R0\u0010\u008c\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u008b\u0001\u0012\u0005\u0012\u00030\u008b\u00010\u008a\u00018\u0016@\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001¨\u0006\u0093\u0001"}, d2 = {"Lcom/discord/app/AppFragment;", "Lcom/discord/app/AppComponent;", "Lcom/discord/app/AppPermissionsRequests;", "Lcom/discord/media_picker/MediaPicker$Provider;", "Lcom/discord/app/AppLogger$a;", "Landroidx/fragment/app/Fragment;", "Lcom/discord/app/AppActivity;", "Landroid/view/View;", "view", "", "bindToolbar", "(Lcom/discord/app/AppActivity;Landroid/view/View;)Lkotlin/Unit;", "requireAppActivity", "()Lcom/discord/app/AppActivity;", "Lkotlin/Function0;", "onSuccess", "requestVideoCallPermissions", "(Lkotlin/jvm/functions/Function0;)V", "requestMedia", "onFailure", "requestMicrophone", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "requestMediaDownload", "requestCameraQRScanner", "requestContacts", "", "hasMedia", "()Z", "openMediaChooser", "()V", "(Landroid/view/View;)Lkotlin/Unit;", "Lcom/discord/views/ToolbarTitleLayout;", "getActionBarTitleLayout", "()Lcom/discord/views/ToolbarTitleLayout;", "setActionBarTitleLayoutExpandedTappableArea", "()Lkotlin/Unit;", "setActionBarTitleLayoutMinimumTappableArea", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "setActionBarTitleColor", "(I)Lkotlin/Unit;", "", "title", "setActionBarTitle", "(Ljava/lang/CharSequence;)Lkotlin/Unit;", "leftDrawable", "(Ljava/lang/CharSequence;Ljava/lang/Integer;)Lkotlin/Unit;", "trailingDrawable", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Ljava/lang/Integer;)V", "titleResId", "subtitle", "setActionBarSubtitle", "subtitleResId", "Landroid/view/View$OnClickListener;", "onClickListener", "setActionBarTitleClick", "(Landroid/view/View$OnClickListener;)Lkotlin/Unit;", "setActionBarTitleAccessibilityViewFocused", "menuResId", "Lrx/functions/Action2;", "Landroid/view/MenuItem;", "Landroid/content/Context;", "onSelected", "Lrx/functions/Action1;", "Landroid/view/Menu;", "onConfigured", "Landroidx/appcompat/widget/Toolbar;", "setActionBarOptionsMenu", "(ILrx/functions/Action2;Lrx/functions/Action1;)Landroidx/appcompat/widget/Toolbar;", "showHomeAsUp", "setActionBarDisplayHomeAsUpEnabled", "(Z)Landroidx/appcompat/widget/Toolbar;", "iconRes", "iconAccessibilityLabel", "(ZLjava/lang/Integer;Ljava/lang/Integer;)Landroidx/appcompat/widget/Toolbar;", "Lkotlin/Function1;", "Landroid/content/Intent;", "action", "setOnNewIntentListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "onResume", "onPause", "onDestroyView", "onDetach", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Ljava/io/File;", "getImageFile", "()Ljava/io/File;", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Lrx/functions/Func0;", "onBackAction", "priority", "setOnBackPressed", "(Lrx/functions/Func0;I)V", "showKeyboard", "hideKeyboard", "getAppActivity", "appActivity", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/lytefast/flexinput/managers/FileManager;", "fileManager$delegate", "Lkotlin/Lazy;", "getFileManager", "()Lcom/lytefast/flexinput/managers/FileManager;", "fileManager", "getMostRecentIntent", "()Landroid/content/Intent;", "mostRecentIntent", "onViewBoundOrOnResumeInvoked", "Z", "<set-?>", "isRecreated", "Lcom/discord/app/AppLogger;", "appLogger$delegate", "getAppLogger", "()Lcom/discord/app/AppLogger;", "appLogger", "Lrx/subjects/Subject;", "Ljava/lang/Void;", "unsubscribeSignal", "Lrx/subjects/Subject;", "getUnsubscribeSignal", "()Lrx/subjects/Subject;", "<init>", "contentResId", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class AppFragment extends Fragment implements AppComponent, AppPermissions2, MediaPicker.Provider, AppLogger.a {

    /* renamed from: appLogger$delegate, reason: from kotlin metadata */
    private final Lazy appLogger;

    /* renamed from: fileManager$delegate, reason: from kotlin metadata */
    private final Lazy fileManager;
    private boolean isRecreated;
    private final AppLogger2 loggingConfig;
    private boolean onViewBoundOrOnResumeInvoked;
    private final Subject<Void, Void> unsubscribeSignal;

    /* compiled from: AppFragment.kt */
    public static final class a extends Lambda implements Function0<AppLogger> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppLogger invoke() {
            return new AppLogger(AppFragment.this, null, false, 6);
        }
    }

    /* compiled from: AppFragment.kt */
    public static final class b extends Lambda implements Function0<SimpleFileManager> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleFileManager invoke() {
            return new SimpleFileManager(AppFragment.this.requireContext(), null, null, 6);
        }
    }

    /* compiled from: AppFragment.kt */
    public static final class c implements MediaPicker.a {
        public c() {
        }

        @Override // com.discord.media_picker.MediaPicker.a
        public void a(Exception exc) {
            Intrinsics3.checkNotNullParameter(exc, "e");
            AppToast.h(AppFragment.this.getContext(), FormatUtils.k(AppFragment.this, R.string.upload_open_file_failed, new Object[]{exc.getMessage()}, null, 4), 0, null, 12);
        }

        @Override // com.discord.media_picker.MediaPicker.a
        public void b(Uri uri, RequestType requestType) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(requestType, "request");
            String mimeType$default = AttachmentUtils.getMimeType$default(AppFragment.this.requireContext().getContentResolver(), uri, null, 4, null);
            if (requestType.ordinal() != 3) {
                AppFragment.this.onImageChosen(uri, mimeType$default);
            } else {
                AppFragment.this.onImageCropped(uri, mimeType$default);
            }
        }
    }

    /* compiled from: AppFragment.kt */
    public static final class d extends Lambda implements Function0<Unit> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() throws IOException {
            MediaPicker mediaPicker = MediaPicker.a;
            AppFragment appFragment = AppFragment.this;
            CharSequence charSequenceK = FormatUtils.k(appFragment, R.string.choose_an_application, new Object[0], null, 4);
            AppFragment2 appFragment2 = new AppFragment2(this);
            Intrinsics3.checkNotNullParameter(appFragment, "provider");
            Intrinsics3.checkNotNullParameter(charSequenceK, "chooserTitle");
            Intrinsics3.checkNotNullParameter("image/*", "mimeType");
            Intrinsics3.checkNotNullParameter(appFragment2, "onError");
            try {
                Uri uriA = mediaPicker.a(appFragment);
                PackageManager packageManager = appFragment.requireContext().getPackageManager();
                Intrinsics3.checkNotNullExpressionValue(packageManager, "provider.requireContext().packageManager");
                Intent intentB = MediaPickerChooser2.b(packageManager, charSequenceK, uriA, "image/*");
                mediaPicker.c(appFragment.requireContext(), new Intent("android.media.action.IMAGE_CAPTURE"), uriA);
                try {
                    appFragment.startActivityForResult(intentB, RequestType.CHOOSER.getCode$media_picker_release());
                } catch (ActivityNotFoundException unused) {
                    throw new IOException("No application available for media picker.");
                }
            } catch (IOException e) {
                appFragment2.invoke(e);
            }
            return Unit.a;
        }
    }

    /* compiled from: AppFragment.kt */
    public static final class e extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ Func0 $onBackAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Func0 func0) {
            super(0);
            this.$onBackAction = func0;
        }

        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            Object objCall = this.$onBackAction.call();
            Intrinsics3.checkNotNullExpressionValue(objCall, "onBackAction.call()");
            return Boolean.valueOf(((Boolean) objCall).booleanValue());
        }
    }

    public AppFragment() {
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.fileManager = LazyJVM.lazy(new b());
        this.appLogger = LazyJVM.lazy(new a());
    }

    public static /* synthetic */ Unit bindToolbar$default(AppFragment appFragment, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindToolbar");
        }
        if ((i & 1) != 0) {
            view = null;
        }
        return appFragment.bindToolbar(view);
    }

    public static /* synthetic */ void hideKeyboard$default(AppFragment appFragment, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideKeyboard");
        }
        if ((i & 1) != 0) {
            view = null;
        }
        appFragment.hideKeyboard(view);
    }

    public static /* synthetic */ Toolbar setActionBarDisplayHomeAsUpEnabled$default(AppFragment appFragment, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionBarDisplayHomeAsUpEnabled");
        }
        if ((i & 1) != 0) {
            z2 = true;
        }
        return appFragment.setActionBarDisplayHomeAsUpEnabled(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Toolbar setActionBarOptionsMenu$default(AppFragment appFragment, int i, Action2 action2, Action1 action1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionBarOptionsMenu");
        }
        if ((i2 & 4) != 0) {
            action1 = null;
        }
        return appFragment.setActionBarOptionsMenu(i, action2, action1);
    }

    public static /* synthetic */ void setOnBackPressed$default(AppFragment appFragment, Func0 func0, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnBackPressed");
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        appFragment.setOnBackPressed(func0, i);
    }

    @CallSuper
    public Unit bindToolbar(View view) {
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        if (view == null) {
            view = getView();
        }
        return bindToolbar(appActivity, view);
    }

    public final ToolbarTitleLayout getActionBarTitleLayout() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.e();
        }
        return null;
    }

    public final AppActivity getAppActivity() {
        return (AppActivity) getActivity();
    }

    public final AppLogger getAppLogger() {
        return (AppLogger) this.appLogger.getValue();
    }

    public final FileManager getFileManager() {
        return (FileManager) this.fileManager.getValue();
    }

    @Override // com.discord.media_picker.MediaPicker.Provider
    public File getImageFile() {
        return getFileManager().b();
    }

    @Override // com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final Intent getMostRecentIntent() {
        Intent intentC;
        AppActivity appActivity = getAppActivity();
        return (appActivity == null || (intentC = appActivity.c()) == null) ? new Intent() : intentC;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // com.discord.app.AppPermissions2
    public boolean hasMedia() {
        return requireAppActivity().appPermissions.hasMedia();
    }

    public final void hideKeyboard() {
        hideKeyboard$default(this, null, 1, null);
    }

    public void hideKeyboard(View view) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.hideKeyboard(view);
        }
    }

    /* renamed from: isRecreated, reason: from getter */
    public final boolean getIsRecreated() {
        return this.isRecreated;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) throws IOException {
        RequestType requestType;
        super.onActivityResult(requestCode, resultCode, data);
        MediaPicker mediaPicker = MediaPicker.a;
        Context contextRequireContext = requireContext();
        c cVar = new c();
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        Intrinsics3.checkNotNullParameter(cVar, "result");
        Objects.requireNonNull(RequestType.INSTANCE);
        if (requestCode == 800) {
            requestType = RequestType.CROP;
        } else if (requestCode != 801) {
            switch (requestCode) {
                case 777:
                    requestType = RequestType.CAMERA;
                    break;
                case 778:
                    requestType = RequestType.GALLERY;
                    break;
                case 779:
                    requestType = RequestType.DOCUMENTS;
                    break;
                default:
                    requestType = null;
                    break;
            }
        } else {
            requestType = RequestType.CHOOSER;
        }
        if (requestType != null) {
            try {
                if (resultCode == -1) {
                    Uri uriD = mediaPicker.d(contextRequireContext, requestType, data);
                    contextRequireContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uriD));
                    cVar.b(uriD, requestType);
                } else {
                    if (resultCode == 0) {
                        return;
                    }
                    throw new IOException("Bad activity result code: " + resultCode + ", for request code: " + requestCode);
                }
            } catch (IOException e2) {
                cVar.a(e2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            String name = getClass().getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            Intrinsics3.checkNotNullParameter(name, "key");
            Collection<HashMap<String, Function0<Boolean>>> collectionValues = appActivity.l.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "backPressHandlers\n        .values");
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                ((HashMap) it.next()).remove(name);
            }
        }
        TextWatcher.INSTANCE.reset(this);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            Intrinsics3.checkNotNullParameter(this, "fragmentOwner");
            appActivity.newIntentListeners.remove(Integer.valueOf(getId()));
        }
        super.onDetach();
    }

    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
    }

    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        getUnsubscribeSignal().onNext(null);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.onViewBoundOrOnResumeInvoked) {
            this.onViewBoundOrOnResumeInvoked = false;
        } else {
            onViewBoundOrOnResume();
        }
    }

    @CallSuper
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
    }

    @CallSuper
    public void onViewBoundOrOnResume() {
        getAppLogger().b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            bindToolbar(appActivity, view);
        }
        this.isRecreated = savedInstanceState != null;
        DisplayUtils.drawUnderSystemBars(view);
        onViewBound(view);
        onViewBoundOrOnResume();
        this.onViewBoundOrOnResumeInvoked = true;
    }

    public final void openMediaChooser() {
        requestMedia(new d());
    }

    @Override // com.discord.app.AppPermissions2
    public void requestCameraQRScanner(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestContacts(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        requireAppActivity().appPermissions.requestContacts(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMedia(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMedia(onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMediaDownload(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMediaDownload(onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMicrophone(Function0<Unit> onFailure, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMicrophone(onFailure, onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestVideoCallPermissions(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestVideoCallPermissions(onSuccess);
    }

    public final AppActivity requireAppActivity() {
        AppActivity appActivity = getAppActivity();
        Intrinsics3.checkNotNull(appActivity);
        return appActivity;
    }

    public final Toolbar setActionBarDisplayHomeAsUpEnabled() {
        return setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    public final Toolbar setActionBarDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        boolean z2 = AppActivity.m;
        return appActivity.k(showHomeAsUp, null, null);
    }

    public final Toolbar setActionBarOptionsMenu(@MenuRes int i, Action2<MenuItem, Context> action2) {
        return setActionBarOptionsMenu$default(this, i, action2, null, 4, null);
    }

    public final Toolbar setActionBarOptionsMenu(@MenuRes int menuResId, Action2<MenuItem, Context> onSelected, Action1<Menu> onConfigured) {
        Toolbar toolbar;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbar = appActivity.toolbar) == null) {
            return null;
        }
        Menu menu = toolbar.getMenu();
        if (menu != null) {
            menu.clear();
        }
        toolbar.inflateMenu(menuResId);
        toolbar.setOnMenuItemClickListener(new AppActivity2(toolbar, menuResId, onSelected, onConfigured));
        Menu menu2 = toolbar.getMenu();
        if (menu2 != null && onConfigured != null) {
            onConfigured.call(menu2);
        }
        return toolbar;
    }

    public final Unit setActionBarSubtitle(CharSequence subtitle) {
        ToolbarTitleLayout toolbarTitleLayoutE;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbarTitleLayoutE = appActivity.e()) == null) {
            return null;
        }
        toolbarTitleLayoutE.setSubtitle(subtitle);
        return Unit.a;
    }

    public final Unit setActionBarTitle(CharSequence title) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.l(title, null);
        }
        return null;
    }

    public final Unit setActionBarTitleAccessibilityViewFocused() {
        ToolbarTitleLayout toolbarTitleLayoutE;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbarTitleLayoutE = appActivity.e()) == null) {
            return null;
        }
        toolbarTitleLayoutE.sendAccessibilityEvent(8);
        return Unit.a;
    }

    public final Unit setActionBarTitleClick(View.OnClickListener onClickListener) {
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        ToolbarTitleLayout toolbarTitleLayoutE = appActivity.e();
        if (toolbarTitleLayoutE == null) {
            return null;
        }
        toolbarTitleLayoutE.setOnClickListener(onClickListener);
        return Unit.a;
    }

    public final Unit setActionBarTitleColor(@ColorInt int color) {
        ToolbarTitleLayout toolbarTitleLayoutE;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbarTitleLayoutE = appActivity.e()) == null) {
            return null;
        }
        toolbarTitleLayoutE.setTitleColor(color);
        return Unit.a;
    }

    public final Unit setActionBarTitleLayoutExpandedTappableArea() {
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        ToolbarTitleLayout toolbarTitleLayoutE = appActivity.e();
        if (toolbarTitleLayoutE != null) {
            toolbarTitleLayoutE.setLayoutParams(new Toolbar.LayoutParams(-1, -1));
        }
        return Unit.a;
    }

    public final Unit setActionBarTitleLayoutMinimumTappableArea() {
        AppActivity appActivity = getAppActivity();
        if (appActivity == null) {
            return null;
        }
        ToolbarTitleLayout toolbarTitleLayoutE = appActivity.e();
        if (toolbarTitleLayoutE != null) {
            toolbarTitleLayoutE.setLayoutParams(new Toolbar.LayoutParams(-2, -2));
        }
        return Unit.a;
    }

    public final void setOnBackPressed(Func0<Boolean> func0) {
        setOnBackPressed$default(this, func0, 0, 2, null);
    }

    public final void setOnBackPressed(Func0<Boolean> onBackAction, int priority) {
        Intrinsics3.checkNotNullParameter(onBackAction, "onBackAction");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            e eVar = new e(onBackAction);
            String name = getClass().getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            Intrinsics3.checkNotNullParameter(eVar, "handler");
            Intrinsics3.checkNotNullParameter(name, "key");
            HashMap<String, Function0<Boolean>> map = appActivity.l.get(Integer.valueOf(priority));
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(name, eVar);
            appActivity.l.put(Integer.valueOf(priority), map);
        }
    }

    public final void setOnNewIntentListener(Function1<? super Intent, Unit> action) {
        Intrinsics3.checkNotNullParameter(action, "action");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            Intrinsics3.checkNotNullParameter(this, "fragmentOwner");
            Intrinsics3.checkNotNullParameter(action, "action");
            appActivity.newIntentListeners.put(Integer.valueOf(getId()), action);
        }
    }

    public void showKeyboard(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.showKeyboard(view);
        }
    }

    private final Unit bindToolbar(AppActivity appActivity, View view) {
        Toolbar toolbar;
        if (view == null || (toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar)) == null) {
            return null;
        }
        if (!Intrinsics3.areEqual(appActivity.toolbar, toolbar)) {
            appActivity.n(toolbar);
        }
        return Unit.a;
    }

    public final Unit setActionBarTitle(CharSequence title, @DrawableRes Integer leftDrawable) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.l(title, leftDrawable);
        }
        return null;
    }

    public static /* synthetic */ Toolbar setActionBarDisplayHomeAsUpEnabled$default(AppFragment appFragment, boolean z2, Integer num, Integer num2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z2 = true;
            }
            return appFragment.setActionBarDisplayHomeAsUpEnabled(z2, num, num2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionBarDisplayHomeAsUpEnabled");
    }

    public final Unit setActionBarSubtitle(@StringRes int subtitleResId) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            String string = getString(subtitleResId);
            ToolbarTitleLayout toolbarTitleLayoutE = appActivity.e();
            if (toolbarTitleLayoutE != null) {
                toolbarTitleLayoutE.setSubtitle(string);
                return Unit.a;
            }
        }
        return null;
    }

    public final void setActionBarTitle(CharSequence title, @DrawableRes Integer leftDrawable, @DrawableRes Integer trailingDrawable) {
        ToolbarTitleLayout toolbarTitleLayoutE;
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || (toolbarTitleLayoutE = appActivity.e()) == null) {
            return;
        }
        toolbarTitleLayoutE.a(title, leftDrawable, trailingDrawable);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestCameraQRScanner(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess);
    }

    public final Toolbar setActionBarDisplayHomeAsUpEnabled(boolean showHomeAsUp, @DrawableRes Integer iconRes, @StringRes Integer iconAccessibilityLabel) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.k(showHomeAsUp, iconRes, iconAccessibilityLabel);
        }
        return null;
    }

    public AppFragment(@LayoutRes int i) {
        super(i);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.fileManager = LazyJVM.lazy(new b());
        this.appLogger = LazyJVM.lazy(new a());
    }

    public final Unit setActionBarTitle(@StringRes int titleResId) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.l(getString(titleResId), null);
        }
        return null;
    }
}
