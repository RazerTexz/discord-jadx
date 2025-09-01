package com.discord.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.i.ImageUploadDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.media_picker.MediaPicker;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.AutocompleteUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: ImageUploadDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 72\u00020\u0001:\u000289B\u0007¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u00104\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006:"}, d2 = {"Lcom/discord/dialogs/ImageUploadDialog;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Landroid/net/Uri;", "m", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "Lb/a/i/b0;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/b0;", "binding", "Lcom/discord/media_picker/MediaPicker$Provider;", "n", "Lcom/discord/media_picker/MediaPicker$Provider;", "getProvider", "()Lcom/discord/media_picker/MediaPicker$Provider;", "setProvider", "(Lcom/discord/media_picker/MediaPicker$Provider;)V", "provider", "", "o", "Ljava/lang/String;", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "mimeType", "Lcom/discord/dialogs/ImageUploadDialog$PreviewType;", "q", "Lcom/discord/dialogs/ImageUploadDialog$PreviewType;", "getPreviewType", "()Lcom/discord/dialogs/ImageUploadDialog$PreviewType;", "setPreviewType", "(Lcom/discord/dialogs/ImageUploadDialog$PreviewType;)V", "previewType", "Lrx/functions/Action1;", "p", "Lrx/functions/Action1;", "getCropResultCallBack", "()Lrx/functions/Action1;", "setCropResultCallBack", "(Lrx/functions/Action1;)V", "cropResultCallBack", "<init>", "()V", "k", "b", "PreviewType", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ImageUploadDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(ImageUploadDialog.class, "binding", "getBinding()Lcom/discord/databinding/ImageUploadDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public Uri uri;

    /* renamed from: n, reason: from kotlin metadata */
    public MediaPicker.Provider provider;

    /* renamed from: o, reason: from kotlin metadata */
    public String mimeType;

    /* renamed from: p, reason: from kotlin metadata */
    public Action1<String> cropResultCallBack;

    /* renamed from: q, reason: from kotlin metadata */
    public PreviewType previewType;

    /* compiled from: ImageUploadDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/discord/dialogs/ImageUploadDialog$PreviewType;", "", "", "previewSizeDimenId", "I", "getPreviewSizeDimenId", "()I", "<init>", "(Ljava/lang/String;II)V", AutocompleteUtils.EMOJI, "USER_AVATAR", "GUILD_AVATAR", "GUILD_SUBSCRIPTION_ROLE_AVATAR", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum PreviewType {
        EMOJI(R.dimen.emoji_size),
        USER_AVATAR(R.dimen.avatar_size_extra_large_account),
        GUILD_AVATAR(R.dimen.avatar_size_xxlarge),
        GUILD_SUBSCRIPTION_ROLE_AVATAR(R.dimen.avatar_size_huge);

        private final int previewSizeDimenId;

        PreviewType(@DimenRes int i) {
            this.previewSizeDimenId = i;
        }

        public final int getPreviewSizeDimenId() {
            return this.previewSizeDimenId;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws IOException {
            int i = this.j;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                ((ImageUploadDialog) this.k).dismiss();
                return;
            }
            Context context = ((ImageUploadDialog) this.k).getContext();
            MediaPicker.Provider provider = ((ImageUploadDialog) this.k).provider;
            if (provider == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("provider");
            }
            Uri uri = ((ImageUploadDialog) this.k).uri;
            if (uri == null) {
                Intrinsics3.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            }
            MGImages.requestImageCrop$default(context, provider, uri, 0.0f, 0.0f, 0, 56, null);
            ((ImageUploadDialog) this.k).dismiss();
        }
    }

    /* compiled from: ImageUploadDialog.kt */
    /* renamed from: com.discord.dialogs.ImageUploadDialog$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: ImageUploadDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, ImageUploadDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, ImageUploadDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ImageUploadDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public ImageUploadDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.notice_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.notice_cancel);
            if (materialButton != null) {
                i = R.id.notice_crop;
                TextView textView = (TextView) view2.findViewById(R.id.notice_crop);
                if (textView != null) {
                    i = R.id.notice_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.notice_image);
                    if (simpleDraweeView != null) {
                        i = R.id.notice_upload;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.notice_upload);
                        if (materialButton2 != null) {
                            return new ImageUploadDialogBinding((LinearLayout) view2, materialButton, textView, simpleDraweeView, materialButton2);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: ImageUploadDialog.kt */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ String k;

        public d(String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = ImageUploadDialog.this.getContext();
            Uri uri = ImageUploadDialog.this.uri;
            if (uri == null) {
                Intrinsics3.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            }
            MGImages.requestDataUrl(context, uri, this.k, ImageUploadDialog.this.cropResultCallBack);
            ImageUploadDialog.this.dismiss();
        }
    }

    public ImageUploadDialog() {
        super(R.layout.image_upload_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final ImageUploadDialogBinding g() {
        return (ImageUploadDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        PreviewType previewType = this.previewType;
        String str = this.mimeType;
        if (previewType == null || str == null) {
            dismiss();
            return;
        }
        boolean zAreEqual = Intrinsics3.areEqual(str, "image/gif");
        g().e.setOnClickListener(new d(str));
        TextView textView = g().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeCrop");
        textView.setVisibility(zAreEqual ? 4 : 0);
        if (!zAreEqual) {
            g().c.setOnClickListener(new a(0, this));
        }
        g().f81b.setOnClickListener(new a(1, this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(previewType.getPreviewSizeDimenId());
        SimpleDraweeView simpleDraweeView = g().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.noticeImage");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = dimensionPixelSize;
        SimpleDraweeView simpleDraweeView2 = g().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.noticeImage");
        simpleDraweeView2.setLayoutParams(layoutParams);
        int iOrdinal = previewType.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            SimpleDraweeView simpleDraweeView3 = g().d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.noticeImage");
            MGImages.setRoundingParams$default(simpleDraweeView3, dimensionPixelSize, true, Integer.valueOf(ColorCompat.getThemedColor(view, R.attr.primary_600)), null, null, 48, null);
        }
        SimpleDraweeView simpleDraweeView4 = g().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.noticeImage");
        Uri uri = this.uri;
        if (uri == null) {
            Intrinsics3.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        }
        MGImages.setImage$default(simpleDraweeView4, uri.toString(), dimensionPixelSize, dimensionPixelSize, false, null, null, 112, null);
    }
}
