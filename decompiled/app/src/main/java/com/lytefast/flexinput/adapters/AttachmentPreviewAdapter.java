package com.lytefast.flexinput.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.b.a.d.ThumbnailViewHolder;
import b.b.a.e.ViewAttachmentPreviewItemBinding;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import com.discord.utilities.drawable.DrawableCompat;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import defpackage.e;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: AttachmentPreviewAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0012\u000e\u0012\f0\u0005R\b\u0012\u0004\u0012\u00028\u00000\u00000\u0004:\u0001\u0010Be\b\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012 \b\u0002\u0010\u001b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0015\u0012.\b\u0002\u0010\u001e\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R1\u0010\u001b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;", "Lcom/lytefast/flexinput/model/Attachment;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter$b;", "", "getItemCount", "()I", "Lcom/lytefast/flexinput/utils/SelectionAggregator;", "a", "Lcom/lytefast/flexinput/utils/SelectionAggregator;", "getSelectionAggregator", "()Lcom/lytefast/flexinput/utils/SelectionAggregator;", "selectionAggregator", "", "b", "Z", "getUseBottomSheet", "()Z", "useBottomSheet", "Lkotlin/Function2;", "", "c", "Lkotlin/jvm/functions/Function2;", "getOnAttachmentSelected", "()Lkotlin/jvm/functions/Function2;", "onAttachmentSelected", "Lkotlin/Function1;", "Lcom/lytefast/flexinput/adapters/SelectionAggregatorProvider;", "selectionAggregatorProvider", "<init>", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AttachmentPreviewAdapter<T extends Attachment<? extends Object>> extends RecyclerView.Adapter<AttachmentPreviewAdapter<T>.b> {

    /* renamed from: a, reason: from kotlin metadata */
    public final SelectionAggregator<T> selectionAggregator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean useBottomSheet;

    /* renamed from: c, reason: from kotlin metadata */
    public final Function2<SelectionAggregator<T>, T, Unit> onAttachmentSelected;

    /* compiled from: AttachmentPreviewAdapter.kt */
    public static final class a extends Lambda implements Function2<SelectionAggregator<T>, T, Unit> {
        public static final a j = new a();

        public a() {
            super(2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Object obj, Object obj2) {
            SelectionAggregator selectionAggregator = (SelectionAggregator) obj;
            Attachment attachment = (Attachment) obj2;
            Intrinsics3.checkNotNullParameter(selectionAggregator, "aggregator");
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            selectionAggregator.unselectItem(attachment);
            return Unit.a;
        }
    }

    /* compiled from: AttachmentPreviewAdapter.kt */
    public final class b extends ThumbnailViewHolder {
        public final ViewAttachmentPreviewItemBinding p;
        public final Function2<SelectionAggregator<T>, T, Unit> q;
        public final /* synthetic */ AttachmentPreviewAdapter r;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public b(AttachmentPreviewAdapter attachmentPreviewAdapter, ViewAttachmentPreviewItemBinding viewAttachmentPreviewItemBinding, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2) {
            Intrinsics3.checkNotNullParameter(viewAttachmentPreviewItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function2, "onAttachmentSelected");
            this.r = attachmentPreviewAdapter;
            ConstraintLayout constraintLayout = viewAttachmentPreviewItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout);
            this.p = viewAttachmentPreviewItemBinding;
            this.q = function2;
            GenericDraweeHierarchy hierarchy = a().getHierarchy();
            Context context = a().getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "imageView.context");
            hierarchy.p(DrawableCompat.getThemedDrawableRes$default(context, R.b.ic_flex_input_file, 0, 2, (Object) null));
        }

        @Override // b.b.a.d.ThumbnailViewHolder
        public SimpleDraweeView a() {
            SimpleDraweeView simpleDraweeView = this.p.f323b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentItem");
            return simpleDraweeView;
        }
    }

    public AttachmentPreviewAdapter() {
        this(false, null, null, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AttachmentPreviewAdapter(boolean z2, Function2 function2, Function1 function1, int i) {
        z2 = (i & 1) != 0 ? false : z2;
        a aVar = (i & 2) != 0 ? a.j : null;
        int i2 = i & 4;
        this(z2, aVar, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.selectionAggregator.getSize();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        b bVar = (b) viewHolder;
        Intrinsics3.checkNotNullParameter(bVar, "holder");
        Attachment attachment = this.selectionAggregator.get(i);
        Objects.requireNonNull(bVar);
        Intrinsics3.checkNotNullParameter(attachment, "item");
        if (attachment instanceof Media) {
            bVar.a().setController(null);
            bVar.c((Media) attachment, null, null);
        } else {
            int dimensionPixelSize = bVar.a().getResources().getDimensionPixelSize(R.d.attachment_preview_dimen);
            ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(attachment.getUri());
            imageRequestBuilderB.e = RotationOptions.a;
            imageRequestBuilderB.d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
            pipelineDraweeControllerBuilderA.n = bVar.a().getController();
            pipelineDraweeControllerBuilderA.m = true;
            pipelineDraweeControllerBuilderA.h = imageRequestBuilderB.a();
            bVar.a().setController(pipelineDraweeControllerBuilderA.a());
        }
        if (!bVar.r.useBottomSheet) {
            SimpleDraweeView simpleDraweeView = bVar.p.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentRemove");
            simpleDraweeView.setVisibility(8);
            bVar.p.f323b.setOnClickListener(new e(2, bVar, attachment));
            return;
        }
        boolean spoiler = attachment.getSpoiler();
        View view = bVar.p.d;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.attachmentSpoilerCover");
        view.setVisibility(spoiler ? 0 : 8);
        SimpleDraweeView simpleDraweeView2 = bVar.p.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentSpoilerIcon");
        simpleDraweeView2.setVisibility(spoiler ? 0 : 8);
        bVar.p.c.setOnClickListener(new e(0, bVar, attachment));
        bVar.p.f323b.setOnClickListener(new e(1, bVar, attachment));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewFindViewById;
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.g.view_attachment_preview_item, viewGroup, false);
        int i2 = R.f.attachment_item;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(i2);
        if (simpleDraweeView != null) {
            i2 = R.f.attachment_remove;
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(i2);
            if (simpleDraweeView2 != null && (viewFindViewById = viewInflate.findViewById((i2 = R.f.attachment_spoiler_cover))) != null) {
                i2 = R.f.attachment_spoiler_icon;
                SimpleDraweeView simpleDraweeView3 = (SimpleDraweeView) viewInflate.findViewById(i2);
                if (simpleDraweeView3 != null) {
                    ViewAttachmentPreviewItemBinding viewAttachmentPreviewItemBinding = new ViewAttachmentPreviewItemBinding((ConstraintLayout) viewInflate, simpleDraweeView, simpleDraweeView2, viewFindViewById, simpleDraweeView3);
                    Intrinsics3.checkNotNullExpressionValue(viewAttachmentPreviewItemBinding, "ViewAttachmentPreviewIte….context), parent, false)");
                    return new b(this, viewAttachmentPreviewItemBinding, this.onAttachmentSelected);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        b bVar = (b) viewHolder;
        Intrinsics3.checkNotNullParameter(bVar, "holder");
        super.onViewRecycled(bVar);
        bVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentPreviewAdapter(boolean z2, Function2<? super SelectionAggregator<T>, ? super T, Unit> function2, Function1<? super AttachmentPreviewAdapter<T>, ? extends SelectionAggregator<T>> function1) {
        SelectionAggregator<T> selectionAggregatorInvoke;
        Intrinsics3.checkNotNullParameter(function2, "onAttachmentSelected");
        this.useBottomSheet = z2;
        this.onAttachmentSelected = function2;
        this.selectionAggregator = (function1 == null || (selectionAggregatorInvoke = function1.invoke(this)) == null) ? new SelectionAggregator<>(this, null, null, null, 14, null) : selectionAggregatorInvoke;
    }
}
