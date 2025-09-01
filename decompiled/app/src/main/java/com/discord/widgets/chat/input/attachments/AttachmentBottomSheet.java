package com.discord.widgets.chat.input.attachments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import b.f.j.d.RotationOptions;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetAttachmentBottomSheetBinding;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: AttachmentBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bC\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R*\u00105\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010%R\u0016\u0010<\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020,0>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/discord/widgets/chat/input/attachments/AttachmentBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "", "getContentViewResId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "loadAttachment", "()V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "spoiler", "markSpoiler", "(Z)V", "updateSpoilerViewSize", "onPause", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lkotlin/Function1;", "onMarkSpoiler", "Lkotlin/jvm/functions/Function1;", "attachmentViewSize", "Ljava/lang/Integer;", "getAttachmentViewSize", "()Ljava/lang/Integer;", "setAttachmentViewSize", "(Ljava/lang/Integer;)V", "Lkotlin/Function0;", "onFileRemoved", "Lkotlin/jvm/functions/Function0;", "Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", "binding", "Lcom/facebook/imagepipeline/image/ImageInfo;", "attachmentImageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "getAttachmentImageInfo", "()Lcom/facebook/imagepipeline/image/ImageInfo;", "setAttachmentImageInfo", "(Lcom/facebook/imagepipeline/image/ImageInfo;)V", "Lcom/lytefast/flexinput/model/Attachment;", "", "attachment", "Lcom/lytefast/flexinput/model/Attachment;", "getAttachment", "()Lcom/lytefast/flexinput/model/Attachment;", "setAttachment", "(Lcom/lytefast/flexinput/model/Attachment;)V", "onDismissed", "isSpoiler", "Z", "Lcom/facebook/drawee/controller/ControllerListener;", "draweeControllerListener", "Lcom/facebook/drawee/controller/ControllerListener;", "getDraweeControllerListener", "()Lcom/facebook/drawee/controller/ControllerListener;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AttachmentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(AttachmentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Attachment<? extends Object> attachment;
    private ImageInfo attachmentImageInfo;
    private Integer attachmentViewSize;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ControllerListener<ImageInfo> draweeControllerListener;
    private boolean isSpoiler;
    private Function0<Unit> onDismissed;
    private Function0<Unit> onFileRemoved;
    private Function1<? super Boolean, Unit> onMarkSpoiler;

    /* compiled from: AttachmentBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/input/attachments/AttachmentBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/lytefast/flexinput/model/Attachment;", "attachment", "Lkotlin/Function0;", "", "onFileRemoved", "Lkotlin/Function1;", "", "onMarkSpoiler", "onDismissed", "Lcom/discord/widgets/chat/input/attachments/AttachmentBottomSheet;", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/lytefast/flexinput/model/Attachment;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Lcom/discord/widgets/chat/input/attachments/AttachmentBottomSheet;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ AttachmentBottomSheet show$default(Companion companion, FragmentManager fragmentManager, Attachment attachment, Function0 function0, Function1 function1, Function0 function02, int i, Object obj) {
            if ((i & 16) != 0) {
                function02 = null;
            }
            return companion.show(fragmentManager, attachment, function0, function1, function02);
        }

        public final AttachmentBottomSheet show(FragmentManager fragmentManager, Attachment<? extends Object> attachment, Function0<Unit> onFileRemoved, Function1<? super Boolean, Unit> onMarkSpoiler, Function0<Unit> onDismissed) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            Intrinsics3.checkNotNullParameter(onFileRemoved, "onFileRemoved");
            Intrinsics3.checkNotNullParameter(onMarkSpoiler, "onMarkSpoiler");
            AttachmentBottomSheet attachmentBottomSheet = new AttachmentBottomSheet();
            attachmentBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("EXTRA_ATTACHMENT", attachment)));
            AttachmentBottomSheet.access$setOnFileRemoved$p(attachmentBottomSheet, onFileRemoved);
            AttachmentBottomSheet.access$setOnMarkSpoiler$p(attachmentBottomSheet, onMarkSpoiler);
            AttachmentBottomSheet.access$setOnDismissed$p(attachmentBottomSheet, onDismissed);
            AttachmentBottomSheet.access$setSpoiler$p(attachmentBottomSheet, attachment.getSpoiler());
            attachmentBottomSheet.show(fragmentManager, Reflection2.getOrCreateKotlinClass(AttachmentBottomSheet.class).toString());
            return attachmentBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AttachmentBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "width", "<anonymous parameter 1>", "height", "<anonymous parameter 3>", "", "invoke", "(IIII)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function4<Integer, Integer, Integer, Integer, Unit> {
        public AnonymousClass1() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
            invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2, int i3, int i4) {
            AttachmentBottomSheet.this.setAttachmentViewSize(Integer.valueOf(i));
            AttachmentBottomSheet.this.updateSpoilerViewSize();
        }
    }

    /* compiled from: AttachmentBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnFileRemoved$p = AttachmentBottomSheet.access$getOnFileRemoved$p(AttachmentBottomSheet.this);
            if (function0Access$getOnFileRemoved$p != null) {
            }
            AttachmentBottomSheet.this.dismiss();
        }
    }

    /* compiled from: AttachmentBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean z2 = !AttachmentBottomSheet.access$isSpoiler$p(AttachmentBottomSheet.this);
            AttachmentBottomSheet.this.markSpoiler(z2);
            Function1 function1Access$getOnMarkSpoiler$p = AttachmentBottomSheet.access$getOnMarkSpoiler$p(AttachmentBottomSheet.this);
            if (function1Access$getOnMarkSpoiler$p != null) {
            }
        }
    }

    public AttachmentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, AttachmentBottomSheet2.INSTANCE, null, 2, null);
        this.draweeControllerListener = new AttachmentBottomSheet3(this);
    }

    public static final /* synthetic */ WidgetAttachmentBottomSheetBinding access$getBinding$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.getBinding();
    }

    public static final /* synthetic */ Function0 access$getOnDismissed$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onDismissed;
    }

    public static final /* synthetic */ Function0 access$getOnFileRemoved$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onFileRemoved;
    }

    public static final /* synthetic */ Function1 access$getOnMarkSpoiler$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onMarkSpoiler;
    }

    public static final /* synthetic */ boolean access$isSpoiler$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.isSpoiler;
    }

    public static final /* synthetic */ void access$setOnDismissed$p(AttachmentBottomSheet attachmentBottomSheet, Function0 function0) {
        attachmentBottomSheet.onDismissed = function0;
    }

    public static final /* synthetic */ void access$setOnFileRemoved$p(AttachmentBottomSheet attachmentBottomSheet, Function0 function0) {
        attachmentBottomSheet.onFileRemoved = function0;
    }

    public static final /* synthetic */ void access$setOnMarkSpoiler$p(AttachmentBottomSheet attachmentBottomSheet, Function1 function1) {
        attachmentBottomSheet.onMarkSpoiler = function1;
    }

    public static final /* synthetic */ void access$setSpoiler$p(AttachmentBottomSheet attachmentBottomSheet, boolean z2) {
        attachmentBottomSheet.isSpoiler = z2;
    }

    private final WidgetAttachmentBottomSheetBinding getBinding() {
        return (WidgetAttachmentBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final Attachment<Object> getAttachment() {
        return this.attachment;
    }

    public final ImageInfo getAttachmentImageInfo() {
        return this.attachmentImageInfo;
    }

    public final Integer getAttachmentViewSize() {
        return this.attachmentViewSize;
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_attachment_bottom_sheet;
    }

    public final ControllerListener<ImageInfo> getDraweeControllerListener() {
        return this.draweeControllerListener;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public final void loadAttachment() {
        Attachment<? extends Object> attachment = this.attachment;
        ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(attachment != null ? attachment.getUri() : null);
        imageRequestBuilderB.e = RotationOptions.a;
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
        pipelineDraweeControllerBuilderA.m = true;
        SimpleDraweeView simpleDraweeView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        pipelineDraweeControllerBuilderA.n = simpleDraweeView.getController();
        pipelineDraweeControllerBuilderA.h = imageRequestBuilderB.a();
        AbstractDraweeController abstractDraweeControllerA = pipelineDraweeControllerBuilderA.a();
        abstractDraweeControllerA.f(this.draweeControllerListener);
        SimpleDraweeView simpleDraweeView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentPreview");
        simpleDraweeView2.setController(abstractDraweeControllerA);
    }

    public final void markSpoiler(boolean spoiler) {
        this.isSpoiler = spoiler;
        MaterialCheckBox materialCheckBox = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.attachmentMarkSpoilerCheckbox");
        materialCheckBox.setChecked(spoiler);
        FrameLayout frameLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.attachmentSpoilerCover");
        frameLayout.setVisibility(spoiler ? 0 : 8);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.attachment = (Attachment) getArgumentsOrDefault().getParcelable("EXTRA_ATTACHMENT");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.onFileRemoved = null;
        this.onMarkSpoiler = null;
        Function0<Unit> function0 = this.onDismissed;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence string;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppCompatTextView appCompatTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appCompatTextView, "binding.attachmentFilename");
        Attachment<? extends Object> attachment = this.attachment;
        appCompatTextView.setText(attachment != null ? attachment.getDisplayName() : null);
        SimpleDraweeView simpleDraweeView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        ViewExtensions.addOnSizeChangedListener(simpleDraweeView, new AnonymousClass1());
        Attachment<? extends Object> attachment2 = this.attachment;
        if (!(attachment2 instanceof Media)) {
            attachment2 = null;
        }
        Media media = (Media) attachment2;
        Long l = media != null ? media.k : null;
        MaterialTextView materialTextView = getBinding().f2227b;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.attachmentDuration");
        materialTextView.setVisibility(l != null ? 0 : 8);
        if (l != null) {
            long jLongValue = l.longValue();
            MaterialTextView materialTextView2 = getBinding().f2227b;
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.attachmentDuration");
            if (jLongValue > 0) {
                string = TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, jLongValue, null, null, 6, null);
            } else {
                Context context = getContext();
                string = context != null ? context.getString(R.string.video) : null;
            }
            materialTextView2.setText(string);
        }
        markSpoiler(this.isSpoiler);
        loadAttachment();
        getBinding().g.setOnClickListener(new AnonymousClass3());
        getBinding().d.setOnClickListener(new AnonymousClass4());
        setPeekHeightBottomView(getBinding().g);
    }

    public final void setAttachment(Attachment<? extends Object> attachment) {
        this.attachment = attachment;
    }

    public final void setAttachmentImageInfo(ImageInfo imageInfo) {
        this.attachmentImageInfo = imageInfo;
    }

    public final void setAttachmentViewSize(Integer num) {
        this.attachmentViewSize = num;
    }

    public final void updateSpoilerViewSize() {
        Integer num;
        ImageInfo imageInfo = this.attachmentImageInfo;
        if (imageInfo == null || (num = this.attachmentViewSize) == null) {
            return;
        }
        int iIntValue = num.intValue();
        int width = imageInfo.getWidth();
        int height = imageInfo.getHeight();
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        Tuples2 tuples2CalculateScaledSize$default = EmbedResourceUtils.calculateScaledSize$default(embedResourceUtils, width, height, iIntValue, iIntValue, resources, 0, 32, null);
        FrameLayout frameLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.attachmentSpoilerCover");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((Number) tuples2CalculateScaledSize$default.getFirst()).intValue();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((Number) tuples2CalculateScaledSize$default.getSecond()).intValue();
        frameLayout.setLayoutParams(layoutParams2);
    }
}
