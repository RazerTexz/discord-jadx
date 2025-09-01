package com.discord.views;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b.a.i.ViewChatUploadListBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.LocalAttachment;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.file.FileUtils2;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.SendUtils5;
import com.lytefast.flexinput.model.Attachment;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FailedUploadList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u001f\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/discord/views/FailedUploadList;", "Landroid/widget/LinearLayout;", "", "Lcom/discord/api/message/LocalAttachment;", "localAttachments", "", "setUp", "(Ljava/util/List;)V", "Lb/a/i/d2;", "j", "Lb/a/i/d2;", "binding", "Lcom/discord/views/FailedUploadView;", "getFailedUploadViews", "()Ljava/util/List;", "failedUploadViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FailedUploadList extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewChatUploadListBinding binding;

    /* compiled from: FailedUploadList.kt */
    public static final class a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final long f2828b;
        public final String c;

        public a(String str, long j, String str2) {
            Intrinsics3.checkNotNullParameter(str, "displayName");
            Intrinsics3.checkNotNullParameter(str2, "mimeType");
            this.a = str;
            this.f2828b = j;
            this.c = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && this.f2828b == aVar.f2828b && Intrinsics3.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            String str = this.a;
            int iA = (a0.a.a.b.a(this.f2828b) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
            String str2 = this.c;
            return iA + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SingleFailedUpload(displayName=");
            sbU.append(this.a);
            sbU.append(", sizeBytes=");
            sbU.append(this.f2828b);
            sbU.append(", mimeType=");
            return outline.J(sbU, this.c, ")");
        }
    }

    /* compiled from: FailedUploadList.kt */
    public static abstract class b {

        /* compiled from: FailedUploadList.kt */
        public static final class a extends b {
            public final List<a> a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(List<a> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.a = list;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && Intrinsics3.areEqual(this.a, ((a) obj).a);
                }
                return true;
            }

            public int hashCode() {
                List<a> list = this.a;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("FewFailedUploads(uploads="), this.a, ")");
            }
        }

        /* compiled from: FailedUploadList.kt */
        /* renamed from: com.discord.views.FailedUploadList$b$b, reason: collision with other inner class name */
        public static final class C0234b extends b {
            public final int a;

            /* renamed from: b, reason: collision with root package name */
            public final long f2829b;

            public C0234b(int i, long j) {
                super(null);
                this.a = i;
                this.f2829b = j;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0234b)) {
                    return false;
                }
                C0234b c0234b = (C0234b) obj;
                return this.a == c0234b.a && this.f2829b == c0234b.f2829b;
            }

            public int hashCode() {
                return a0.a.a.b.a(this.f2829b) + (this.a * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ManyFailedUploads(uploadCount=");
                sbU.append(this.a);
                sbU.append(", sizeBytes=");
                return outline.C(sbU, this.f2829b, ")");
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public FailedUploadList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_chat_upload_list, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.chat_upload_1;
        FailedUploadView failedUploadView = (FailedUploadView) viewInflate.findViewById(R.id.chat_upload_1);
        if (failedUploadView != null) {
            i = R.id.chat_upload_2;
            FailedUploadView failedUploadView2 = (FailedUploadView) viewInflate.findViewById(R.id.chat_upload_2);
            if (failedUploadView2 != null) {
                i = R.id.chat_upload_3;
                FailedUploadView failedUploadView3 = (FailedUploadView) viewInflate.findViewById(R.id.chat_upload_3);
                if (failedUploadView3 != null) {
                    ViewChatUploadListBinding viewChatUploadListBinding = new ViewChatUploadListBinding((LinearLayout) viewInflate, failedUploadView, failedUploadView2, failedUploadView3);
                    Intrinsics3.checkNotNullExpressionValue(viewChatUploadListBinding, "ViewChatUploadListBindin…rom(context), this, true)");
                    this.binding = viewChatUploadListBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final List<FailedUploadView> getFailedUploadViews() {
        FailedUploadView failedUploadView = this.binding.f98b;
        Intrinsics3.checkNotNullExpressionValue(failedUploadView, "binding.chatUpload1");
        FailedUploadView failedUploadView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(failedUploadView2, "binding.chatUpload2");
        FailedUploadView failedUploadView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(failedUploadView3, "binding.chatUpload3");
        return Collections2.listOf((Object[]) new FailedUploadView[]{failedUploadView, failedUploadView2, failedUploadView3});
    }

    public final void setUp(List<LocalAttachment> localAttachments) {
        Object c0234b;
        Intrinsics3.checkNotNullParameter(localAttachments, "localAttachments");
        Iterator<T> it = getFailedUploadViews().iterator();
        while (it.hasNext()) {
            ((FailedUploadView) it.next()).setVisibility(8);
        }
        if (!localAttachments.isEmpty()) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(localAttachments, 10));
            Iterator<T> it2 = localAttachments.iterator();
            while (it2.hasNext()) {
                arrayList.add(AttachmentUtils.toAttachment((LocalAttachment) it2.next()));
            }
            if (arrayList.size() <= 3) {
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Attachment attachment = (Attachment) it3.next();
                    String displayName = attachment.getDisplayName();
                    Uri uri = attachment.getUri();
                    Context context = getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    ContentResolver contentResolver = context.getContentResolver();
                    Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                    long jComputeFileSizeBytes = SendUtils5.computeFileSizeBytes(uri, contentResolver);
                    Context context2 = getContext();
                    Intrinsics3.checkNotNullExpressionValue(context2, "context");
                    arrayList2.add(new a(displayName, jComputeFileSizeBytes, AttachmentUtils.getMimeType(attachment, context2.getContentResolver())));
                }
                c0234b = new b.a(arrayList2);
            } else {
                long jComputeFileSizeBytes2 = 0;
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    Uri uri2 = ((Attachment) it4.next()).getUri();
                    Context context3 = getContext();
                    Intrinsics3.checkNotNullExpressionValue(context3, "context");
                    ContentResolver contentResolver2 = context3.getContentResolver();
                    Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                    jComputeFileSizeBytes2 += SendUtils5.computeFileSizeBytes(uri2, contentResolver2);
                }
                c0234b = new b.C0234b(arrayList.size(), jComputeFileSizeBytes2);
            }
            if (c0234b instanceof b.a) {
                List<a> list = ((b.a) c0234b).a;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    a aVar = list.get(i);
                    FailedUploadView failedUploadView = getFailedUploadViews().get(i);
                    failedUploadView.setVisibility(0);
                    String str = aVar.a;
                    Context context4 = failedUploadView.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context4, "context");
                    failedUploadView.a(str, FileUtils2.getIconForFiletype(context4, aVar.c), FileUtils2.getSizeSubtitle(aVar.f2828b));
                }
                return;
            }
            if (c0234b instanceof b.C0234b) {
                b.C0234b c0234b2 = (b.C0234b) c0234b;
                int i2 = c0234b2.a;
                long j = c0234b2.f2829b;
                ((View) _Collections.first((List) getFailedUploadViews())).setVisibility(0);
                FailedUploadView failedUploadView2 = (FailedUploadView) _Collections.first((List) getFailedUploadViews());
                Resources resources = failedUploadView2.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                Context context5 = failedUploadView2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context5, "context");
                CharSequence quantityString = StringResourceUtils.getQuantityString(resources, context5, R.plurals.uploading_files_failed_count, i2, Integer.valueOf(i2));
                Context context6 = failedUploadView2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context6, "context");
                failedUploadView2.a(quantityString, DrawableCompat.getThemedDrawableRes$default(context6, R.attr.ic_uploads_generic, 0, 2, (Object) null), FileUtils2.getSizeSubtitle(j));
            }
        }
    }
}
