package com.discord.widgets.chat.input.attachments;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetAttachmentBottomSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: AttachmentBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class AttachmentBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetAttachmentBottomSheetBinding> {
    public static final AttachmentBottomSheet2 INSTANCE = new AttachmentBottomSheet2();

    public AttachmentBottomSheet2() {
        super(1, WidgetAttachmentBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAttachmentBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAttachmentBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.attachment_duration;
        MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.attachment_duration);
        if (materialTextView != null) {
            i = R.id.attachment_filename;
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.attachment_filename);
            if (appCompatTextView != null) {
                i = R.id.attachment_mark_spoiler;
                AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) view.findViewById(R.id.attachment_mark_spoiler);
                if (appCompatCheckedTextView != null) {
                    i = R.id.attachment_mark_spoiler_checkbox;
                    MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.attachment_mark_spoiler_checkbox);
                    if (materialCheckBox != null) {
                        i = R.id.attachment_preview;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.attachment_preview);
                        if (simpleDraweeView != null) {
                            i = R.id.attachment_remove_item;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.attachment_remove_item);
                            if (appCompatTextView2 != null) {
                                i = R.id.attachment_spoiler_cover;
                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.attachment_spoiler_cover);
                                if (frameLayout != null) {
                                    i = R.id.attachment_spoiler_cover_bg;
                                    View viewFindViewById = view.findViewById(R.id.attachment_spoiler_cover_bg);
                                    if (viewFindViewById != null) {
                                        i = R.id.widget_sheet_component_bottom_sheet_header;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.widget_sheet_component_bottom_sheet_header);
                                        if (constraintLayout != null) {
                                            return new WidgetAttachmentBottomSheetBinding((NestedScrollView) view, materialTextView, appCompatTextView, appCompatCheckedTextView, materialCheckBox, simpleDraweeView, appCompatTextView2, frameLayout, viewFindViewById, constraintLayout);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
