package com.discord.widgets.chat.input;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import b.i.c.m.d.k.CommonUtils;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: WidgetChatInputAttachments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/lytefast/flexinput/model/Attachment;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lytefast/flexinput/utils/SelectionAggregator;", "aggregator", "attachment", "", "invoke", "(Lcom/lytefast/flexinput/utils/SelectionAggregator;Lcom/lytefast/flexinput/model/Attachment;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1<T> extends Lambda implements Function2<SelectionAggregator<T>, T, Unit> {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/lytefast/flexinput/model/Attachment;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SelectionAggregator $aggregator;
        public final /* synthetic */ Attachment $attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SelectionAggregator selectionAggregator, Attachment attachment) {
            super(0);
            this.$aggregator = selectionAggregator;
            this.$attachment = attachment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$aggregator.unselectItem(this.$attachment);
        }
    }

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/lytefast/flexinput/model/Attachment;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "spoiler", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ SelectionAggregator $aggregator;
        public final /* synthetic */ Attachment $attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Attachment attachment, SelectionAggregator selectionAggregator) {
            super(1);
            this.$attachment = attachment;
            this.$aggregator = selectionAggregator;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            this.$attachment.setSpoiler(z2);
            this.$aggregator.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1(WidgetChatInputAttachments widgetChatInputAttachments) {
        super(2);
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke((SelectionAggregator) obj, (Attachment) obj2);
        return Unit.a;
    }

    /* JADX WARN: Incorrect types in method signature: (Lcom/lytefast/flexinput/utils/SelectionAggregator<TT;>;TT;)V */
    public final void invoke(SelectionAggregator selectionAggregator, Attachment attachment) {
        Intrinsics3.checkNotNullParameter(selectionAggregator, "aggregator");
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        CommonUtils.r(WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).requireContext(), WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).l());
        AttachmentBottomSheet.Companion companion = AttachmentBottomSheet.INSTANCE;
        FragmentManager childFragmentManager = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "flexInputFragment.childFragmentManager");
        AttachmentBottomSheet.Companion.show$default(companion, childFragmentManager, attachment, new AnonymousClass1(selectionAggregator, attachment), new AnonymousClass2(attachment, selectionAggregator), null, 16, null);
    }
}
