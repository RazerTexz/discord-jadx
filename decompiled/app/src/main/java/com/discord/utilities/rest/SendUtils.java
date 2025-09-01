package com.discord.utilities.rest;

import a0.a.a.b;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.AppToast;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b0.a.a.Compressor;
import b0.a.a.Compressor2;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.CountingRequestBody;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.lytefast.flexinput.model.Attachment;
import d0.Result3;
import d0.Tuples;
import d0.f0.SequenceBuilder2;
import d0.f0.SequenceBuilder3;
import d0.f0._Sequences2;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl5;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* compiled from: SendUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002<=B\t\b\u0002¢\u0006\u0004\b:\u0010;J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJK\u0010\u0012\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000f*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0016\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u001a2\u0012\u0010\u0016\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$JC\u0010-\u001a\u00020*2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0007¢\u0006\u0004\b-\u0010.J\u0015\u00101\u001a\u00020*2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102JE\u00105\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u001c\u00104\u001a\u0018\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\u0012\u0004\u0012\u00020*03¢\u0006\u0004\b5\u00106R\u0016\u00107\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u00108¨\u0006>"}, d2 = {"Lcom/discord/utilities/rest/SendUtils;", "", "Landroid/content/ContentResolver;", "contentResolver", "", "Lcom/lytefast/flexinput/model/Attachment;", "fileAttachments", "Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "getPreprocessingFromAttachments", "(Landroid/content/ContentResolver;Ljava/util/List;)Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "", "Lkotlin/Pair;", "splitFileExtension", "(Ljava/lang/String;)Lkotlin/Pair;", ModelAuditLogEntry.CHANGE_KEY_NAME, "Lrx/Observable;", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "kotlin.jvm.PlatformType", "getPart", "(Lcom/lytefast/flexinput/model/Attachment;Landroid/content/ContentResolver;Ljava/lang/String;)Lrx/Observable;", "Lcom/discord/restapi/RestAPIParams$Message;", "apiParamMessage", "attachments", "Lcom/discord/utilities/rest/SendUtils$SendPayload;", "getSendPayload", "(Landroid/content/ContentResolver;Lcom/discord/restapi/RestAPIParams$Message;Ljava/util/List;)Lrx/Observable;", "Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "getSendCommandPayload", "(Landroid/content/ContentResolver;Lcom/discord/models/commands/ApplicationCommandLocalSendData;Ljava/util/List;)Lrx/Observable;", "attachmentParts", "uniqueifyNames", "(Ljava/util/List;)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "", "count", "renamedWithDuplicateCount", "(Lcom/lytefast/flexinput/model/Attachment;I)Lcom/lytefast/flexinput/model/Attachment;", "Lcom/discord/utilities/error/Error;", "error", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "filesTooLargeCallback", "failedDeliveryToRecipientCallback", "handleSendError", "(Lcom/discord/utilities/error/Error;Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/utilities/messagesend/MessageResult$CaptchaRequired;", "messageResult", "handleCaptchaRequired", "(Lcom/discord/utilities/messagesend/MessageResult$CaptchaRequired;)V", "Lkotlin/Function1;", "onCompressed", "compressImageAttachments", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "MAX_MESSAGE_CHARACTER_COUNT", "I", "MAX_MESSAGE_CHARACTER_COUNT_PREMIUM", "<init>", "()V", "FileUpload", "SendPayload", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SendUtils {
    public static final SendUtils INSTANCE = new SendUtils();
    public static final int MAX_MESSAGE_CHARACTER_COUNT = 2000;
    public static final int MAX_MESSAGE_CHARACTER_COUNT_PREMIUM = 4000;

    /* compiled from: SendUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B5\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0007R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u000e¨\u0006*"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$FileUpload;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "Lokhttp3/MultipartBody$Part;", "component3", "()Lokhttp3/MultipartBody$Part;", "component4", "Lrx/Observable;", "component5", "()Lrx/Observable;", ModelAuditLogEntry.CHANGE_KEY_NAME, "contentLength", "part", "mimeType", "bytesWrittenObservable", "copy", "(Ljava/lang/String;JLokhttp3/MultipartBody$Part;Ljava/lang/String;Lrx/Observable;)Lcom/discord/utilities/rest/SendUtils$FileUpload;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMimeType", "getName", "Lokhttp3/MultipartBody$Part;", "getPart", "J", "getContentLength", "Lrx/Observable;", "getBytesWrittenObservable", "<init>", "(Ljava/lang/String;JLokhttp3/MultipartBody$Part;Ljava/lang/String;Lrx/Observable;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class FileUpload {
        public static final long SIZE_UNKNOWN = -1;
        private final Observable<Long> bytesWrittenObservable;
        private final long contentLength;
        private final String mimeType;
        private final String name;
        private final MultipartBody.Part part;

        public FileUpload(String str, long j, MultipartBody.Part part, String str2, Observable<Long> observable) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(part, "part");
            Intrinsics3.checkNotNullParameter(str2, "mimeType");
            Intrinsics3.checkNotNullParameter(observable, "bytesWrittenObservable");
            this.name = str;
            this.contentLength = j;
            this.part = part;
            this.mimeType = str2;
            this.bytesWrittenObservable = observable;
        }

        public static /* synthetic */ FileUpload copy$default(FileUpload fileUpload, String str, long j, MultipartBody.Part part, String str2, Observable observable, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileUpload.name;
            }
            if ((i & 2) != 0) {
                j = fileUpload.contentLength;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                part = fileUpload.part;
            }
            MultipartBody.Part part2 = part;
            if ((i & 8) != 0) {
                str2 = fileUpload.mimeType;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                observable = fileUpload.bytesWrittenObservable;
            }
            return fileUpload.copy(str, j2, part2, str3, observable);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final long getContentLength() {
            return this.contentLength;
        }

        /* renamed from: component3, reason: from getter */
        public final MultipartBody.Part getPart() {
            return this.part;
        }

        /* renamed from: component4, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public final Observable<Long> component5() {
            return this.bytesWrittenObservable;
        }

        public final FileUpload copy(String name, long contentLength, MultipartBody.Part part, String mimeType, Observable<Long> bytesWrittenObservable) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(part, "part");
            Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
            Intrinsics3.checkNotNullParameter(bytesWrittenObservable, "bytesWrittenObservable");
            return new FileUpload(name, contentLength, part, mimeType, bytesWrittenObservable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileUpload)) {
                return false;
            }
            FileUpload fileUpload = (FileUpload) other;
            return Intrinsics3.areEqual(this.name, fileUpload.name) && this.contentLength == fileUpload.contentLength && Intrinsics3.areEqual(this.part, fileUpload.part) && Intrinsics3.areEqual(this.mimeType, fileUpload.mimeType) && Intrinsics3.areEqual(this.bytesWrittenObservable, fileUpload.bytesWrittenObservable);
        }

        public final Observable<Long> getBytesWrittenObservable() {
            return this.bytesWrittenObservable;
        }

        public final long getContentLength() {
            return this.contentLength;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final String getName() {
            return this.name;
        }

        public final MultipartBody.Part getPart() {
            return this.part;
        }

        public int hashCode() {
            String str = this.name;
            int iA = (b.a(this.contentLength) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
            MultipartBody.Part part = this.part;
            int iHashCode = (iA + (part != null ? part.hashCode() : 0)) * 31;
            String str2 = this.mimeType;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Observable<Long> observable = this.bytesWrittenObservable;
            return iHashCode2 + (observable != null ? observable.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("FileUpload(name=");
            sbU.append(this.name);
            sbU.append(", contentLength=");
            sbU.append(this.contentLength);
            sbU.append(", part=");
            sbU.append(this.part);
            sbU.append(", mimeType=");
            sbU.append(this.mimeType);
            sbU.append(", bytesWrittenObservable=");
            sbU.append(this.bytesWrittenObservable);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: SendUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload;", "", "<init>", "()V", "Preprocessing", "ReadyToSend", "ReadyToSendCommand", "Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;", "Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSendCommand;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class SendPayload {

        /* compiled from: SendUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "Lcom/discord/utilities/rest/SendUtils$SendPayload;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "numFiles", ModelAuditLogEntry.CHANGE_KEY_NAME, "mimeType", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMimeType", "I", "getNumFiles", "getName", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Preprocessing extends SendPayload {
            private final String mimeType;
            private final String name;
            private final int numFiles;

            public Preprocessing(int i, String str, String str2) {
                super(null);
                this.numFiles = i;
                this.name = str;
                this.mimeType = str2;
            }

            public static /* synthetic */ Preprocessing copy$default(Preprocessing preprocessing, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = preprocessing.numFiles;
                }
                if ((i2 & 2) != 0) {
                    str = preprocessing.name;
                }
                if ((i2 & 4) != 0) {
                    str2 = preprocessing.mimeType;
                }
                return preprocessing.copy(i, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* renamed from: component3, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            public final Preprocessing copy(int numFiles, String name, String mimeType) {
                return new Preprocessing(numFiles, name, mimeType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Preprocessing)) {
                    return false;
                }
                Preprocessing preprocessing = (Preprocessing) other;
                return this.numFiles == preprocessing.numFiles && Intrinsics3.areEqual(this.name, preprocessing.name) && Intrinsics3.areEqual(this.mimeType, preprocessing.mimeType);
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final String getName() {
                return this.name;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public int hashCode() {
                int i = this.numFiles * 31;
                String str = this.name;
                int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mimeType;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Preprocessing(numFiles=");
                sbU.append(this.numFiles);
                sbU.append(", name=");
                sbU.append(this.name);
                sbU.append(", mimeType=");
                return outline.J(sbU, this.mimeType, ")");
            }
        }

        /* compiled from: SendUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;", "Lcom/discord/utilities/rest/SendUtils$SendPayload;", "Lcom/discord/restapi/RestAPIParams$Message;", "component1", "()Lcom/discord/restapi/RestAPIParams$Message;", "", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "component2", "()Ljava/util/List;", "message", "uploads", "copy", "(Lcom/discord/restapi/RestAPIParams$Message;Ljava/util/List;)Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/restapi/RestAPIParams$Message;", "getMessage", "Ljava/util/List;", "getUploads", "<init>", "(Lcom/discord/restapi/RestAPIParams$Message;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ReadyToSend extends SendPayload {
            private final RestAPIParams.Message message;
            private final List<FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToSend(RestAPIParams.Message message, List<FileUpload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.message = message;
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ReadyToSend copy$default(ReadyToSend readyToSend, RestAPIParams.Message message, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = readyToSend.message;
                }
                if ((i & 2) != 0) {
                    list = readyToSend.uploads;
                }
                return readyToSend.copy(message, list);
            }

            /* renamed from: component1, reason: from getter */
            public final RestAPIParams.Message getMessage() {
                return this.message;
            }

            public final List<FileUpload> component2() {
                return this.uploads;
            }

            public final ReadyToSend copy(RestAPIParams.Message message, List<FileUpload> uploads) {
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new ReadyToSend(message, uploads);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReadyToSend)) {
                    return false;
                }
                ReadyToSend readyToSend = (ReadyToSend) other;
                return Intrinsics3.areEqual(this.message, readyToSend.message) && Intrinsics3.areEqual(this.uploads, readyToSend.uploads);
            }

            public final RestAPIParams.Message getMessage() {
                return this.message;
            }

            public final List<FileUpload> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                RestAPIParams.Message message = this.message;
                int iHashCode = (message != null ? message.hashCode() : 0) * 31;
                List<FileUpload> list = this.uploads;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ReadyToSend(message=");
                sbU.append(this.message);
                sbU.append(", uploads=");
                return outline.L(sbU, this.uploads, ")");
            }
        }

        /* compiled from: SendUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSendCommand;", "Lcom/discord/utilities/rest/SendUtils$SendPayload;", "Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "component1", "()Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "component2", "()Ljava/util/List;", "command", "uploads", "copy", "(Lcom/discord/models/commands/ApplicationCommandLocalSendData;Ljava/util/List;)Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSendCommand;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "getCommand", "Ljava/util/List;", "getUploads", "<init>", "(Lcom/discord/models/commands/ApplicationCommandLocalSendData;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ReadyToSendCommand extends SendPayload {
            private final ApplicationCommandLocalSendData command;
            private final List<FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToSendCommand(ApplicationCommandLocalSendData applicationCommandLocalSendData, List<FileUpload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(applicationCommandLocalSendData, "command");
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.command = applicationCommandLocalSendData;
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ReadyToSendCommand copy$default(ReadyToSendCommand readyToSendCommand, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    applicationCommandLocalSendData = readyToSendCommand.command;
                }
                if ((i & 2) != 0) {
                    list = readyToSendCommand.uploads;
                }
                return readyToSendCommand.copy(applicationCommandLocalSendData, list);
            }

            /* renamed from: component1, reason: from getter */
            public final ApplicationCommandLocalSendData getCommand() {
                return this.command;
            }

            public final List<FileUpload> component2() {
                return this.uploads;
            }

            public final ReadyToSendCommand copy(ApplicationCommandLocalSendData command, List<FileUpload> uploads) {
                Intrinsics3.checkNotNullParameter(command, "command");
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new ReadyToSendCommand(command, uploads);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReadyToSendCommand)) {
                    return false;
                }
                ReadyToSendCommand readyToSendCommand = (ReadyToSendCommand) other;
                return Intrinsics3.areEqual(this.command, readyToSendCommand.command) && Intrinsics3.areEqual(this.uploads, readyToSendCommand.uploads);
            }

            public final ApplicationCommandLocalSendData getCommand() {
                return this.command;
            }

            public final List<FileUpload> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                ApplicationCommandLocalSendData applicationCommandLocalSendData = this.command;
                int iHashCode = (applicationCommandLocalSendData != null ? applicationCommandLocalSendData.hashCode() : 0) * 31;
                List<FileUpload> list = this.uploads;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ReadyToSendCommand(command=");
                sbU.append(this.command);
                sbU.append(", uploads=");
                return outline.L(sbU, this.uploads, ")");
            }
        }

        private SendPayload() {
        }

        public /* synthetic */ SendPayload(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SendUtils.kt */
    @DebugMetadata(c = "com.discord.utilities.rest.SendUtils$compressImageAttachments$1", f = "SendUtils.kt", l = {323}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.SendUtils$compressImageAttachments$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List $attachments;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Function1 $onCompressed;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, Context context, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$attachments = list;
            this.$context = context;
            this.$onCompressed = function1;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$attachments, this.$context, this.$onCompressed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
        
            r5 = r4;
            r4 = r3;
            r3 = r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008c -> B:36:0x0093). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00bc -> B:27:0x00c1). Please report as a decompilation issue!!! */
        @Override // d0.w.i.a.ContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Collection arrayList;
            Iterator it;
            AnonymousClass1 anonymousClass1;
            Collection collection;
            Collection collection2;
            Iterator it2;
            Attachment<Uri> attachmentB;
            Collection collection3;
            Object obj2;
            AnonymousClass1 anonymousClass12;
            Attachment<Uri> attachment;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                List list = this.$attachments;
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                it = list.iterator();
                anonymousClass1 = this;
                if (it.hasNext()) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList = (Collection) this.L$3;
                Attachment<Uri> attachment2 = (Attachment) this.L$2;
                it = (Iterator) this.L$1;
                Collection collection4 = (Collection) this.L$0;
                try {
                    Result3.throwOnFailure(obj);
                    collection3 = collection4;
                    it2 = it;
                    attachment = attachment2;
                    collection = arrayList;
                    obj2 = coroutine_suspended;
                    anonymousClass12 = this;
                } catch (Exception unused) {
                    anonymousClass1 = this;
                    Attachment<Uri> attachment3 = attachment2;
                    collection = arrayList;
                    collection2 = collection4;
                    it2 = it;
                    attachmentB = attachment3;
                    Collection collection5 = collection;
                    Collection collection6 = collection2;
                    arrayList = collection5;
                    arrayList.add(attachmentB);
                    arrayList = collection6;
                    it = it2;
                    if (it.hasNext()) {
                    }
                }
                try {
                } catch (Exception unused2) {
                    anonymousClass1 = anonymousClass12;
                    coroutine_suspended = obj2;
                    arrayList = collection;
                    attachment2 = attachment;
                    it = it2;
                    collection4 = collection3;
                    Attachment<Uri> attachment32 = attachment2;
                    collection = arrayList;
                    collection2 = collection4;
                    it2 = it;
                    attachmentB = attachment32;
                    Collection collection52 = collection;
                    Collection collection62 = collection2;
                    arrayList = collection52;
                    arrayList.add(attachmentB);
                    arrayList = collection62;
                    it = it2;
                    if (it.hasNext()) {
                    }
                }
                Uri uriFromFile = Uri.fromFile((File) obj);
                Attachment.Companion companion = Attachment.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(uriFromFile, "resultUri");
                ContentResolver contentResolver = anonymousClass12.$context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                attachmentB = companion.b(uriFromFile, contentResolver);
                anonymousClass1 = anonymousClass12;
                coroutine_suspended = obj2;
                collection2 = collection3;
                Collection collection522 = collection;
                Collection collection622 = collection2;
                arrayList = collection522;
                arrayList.add(attachmentB);
                arrayList = collection622;
                it = it2;
                if (it.hasNext()) {
                    attachment2 = (Attachment) it.next();
                    if (!AttachmentUtils.isImage(attachment2, anonymousClass1.$context.getContentResolver()) || AttachmentUtils.isGif(attachment2, anonymousClass1.$context.getContentResolver())) {
                        it2 = it;
                        attachmentB = attachment2;
                        collection622 = arrayList;
                        arrayList.add(attachmentB);
                        arrayList = collection622;
                        it = it2;
                        if (it.hasNext()) {
                            anonymousClass1.$onCompressed.invoke((List) arrayList);
                            return Unit.a;
                        }
                    } else {
                        try {
                        } catch (Exception unused3) {
                            collection4 = arrayList;
                            Attachment<Uri> attachment322 = attachment2;
                            collection = arrayList;
                            collection2 = collection4;
                            it2 = it;
                            attachmentB = attachment322;
                            Collection collection5222 = collection;
                            Collection collection6222 = collection2;
                            arrayList = collection5222;
                            arrayList.add(attachmentB);
                            arrayList = collection6222;
                            it = it2;
                            if (it.hasNext()) {
                            }
                        }
                        Context context = anonymousClass1.$context;
                        Uri uri = attachment2.getUri();
                        anonymousClass1.L$0 = arrayList;
                        anonymousClass1.L$1 = it;
                        anonymousClass1.L$2 = attachment2;
                        anonymousClass1.L$3 = arrayList;
                        anonymousClass1.label = 1;
                        Object objC1 = f.C1(Dispatchers.f3842b, new Compressor2(Compressor.j, context, uri, null), anonymousClass1);
                        if (objC1 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        collection3 = arrayList;
                        obj2 = coroutine_suspended;
                        anonymousClass12 = anonymousClass1;
                        obj = objC1;
                        it2 = it;
                        attachment = attachment2;
                        collection = collection3;
                        Uri uriFromFile2 = Uri.fromFile((File) obj);
                        Attachment.Companion companion2 = Attachment.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(uriFromFile2, "resultUri");
                        ContentResolver contentResolver2 = anonymousClass12.$context.getContentResolver();
                        Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                        attachmentB = companion2.b(uriFromFile2, contentResolver2);
                        anonymousClass1 = anonymousClass12;
                        coroutine_suspended = obj2;
                        collection2 = collection3;
                        Collection collection52222 = collection;
                        Collection collection62222 = collection2;
                        arrayList = collection52222;
                        arrayList.add(attachmentB);
                        arrayList = collection62222;
                        it = it2;
                        if (it.hasNext()) {
                        }
                    }
                }
            }
        }
    }

    /* compiled from: SendUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lrx/Emitter;", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "kotlin.jvm.PlatformType", "emitter", "", NotificationCompat.CATEGORY_CALL, "(Lrx/Emitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.SendUtils$getPart$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Emitter<FileUpload>> {
        public final /* synthetic */ ContentResolver $contentResolver;
        public final /* synthetic */ String $name;
        public final /* synthetic */ Attachment $this_getPart;

        /* compiled from: SendUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lokhttp3/RequestBody;", "requestBody", "", "mimeType", "Landroid/graphics/Bitmap$CompressFormat;", "compressFormat", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "invoke", "(Lokhttp3/RequestBody;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;)Lcom/discord/utilities/rest/SendUtils$FileUpload;", "getFileUpload"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.rest.SendUtils$getPart$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02221 extends Lambda implements Function3<RequestBody, String, Bitmap.CompressFormat, FileUpload> {
            public C02221() {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FileUpload invoke(RequestBody requestBody, String str, Bitmap.CompressFormat compressFormat) {
                return invoke2(requestBody, str, compressFormat);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final FileUpload invoke2(RequestBody requestBody, String str, Bitmap.CompressFormat compressFormat) {
                Intrinsics3.checkNotNullParameter(requestBody, "requestBody");
                Intrinsics3.checkNotNullParameter(str, "mimeType");
                CountingRequestBody countingRequestBody = new CountingRequestBody(requestBody, 0);
                String sanitizedFileName = AttachmentUtils.getSanitizedFileName(Attachment.INSTANCE.a(AnonymousClass1.this.$this_getPart), compressFormat);
                return new FileUpload(sanitizedFileName, countingRequestBody.getEstimatedContentLength(), MultipartBody.Part.b(AnonymousClass1.this.$name, sanitizedFileName, countingRequestBody), str, countingRequestBody.getBytesWrittenObservable());
            }
        }

        public AnonymousClass1(Attachment attachment, String str, ContentResolver contentResolver) {
            this.$this_getPart = attachment;
            this.$name = str;
            this.$contentResolver = contentResolver;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<FileUpload> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<FileUpload> emitter) {
            emitter.onNext(new C02221().invoke2((RequestBody) new AttachmentRequestBody(this.$contentResolver, this.$this_getPart), AttachmentUtils.getMimeType(this.$this_getPart, this.$contentResolver), (Bitmap.CompressFormat) null));
            emitter.onCompleted();
        }
    }

    /* compiled from: SendUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00050\u00052*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "kotlin.jvm.PlatformType", "", "attachmentParts", "Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSendCommand;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSendCommand;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.SendUtils$getSendCommandPayload$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<List<FileUpload>, SendPayload.ReadyToSendCommand> {
        public final /* synthetic */ ApplicationCommandLocalSendData $attachmentCorrectedMessage;

        public AnonymousClass2(ApplicationCommandLocalSendData applicationCommandLocalSendData) {
            this.$attachmentCorrectedMessage = applicationCommandLocalSendData;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ SendPayload.ReadyToSendCommand call(List<FileUpload> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final SendPayload.ReadyToSendCommand call2(List<FileUpload> list) {
            ApplicationCommandLocalSendData applicationCommandLocalSendData = this.$attachmentCorrectedMessage;
            Intrinsics3.checkNotNullExpressionValue(list, "attachmentParts");
            return new SendPayload.ReadyToSendCommand(applicationCommandLocalSendData, list);
        }
    }

    /* compiled from: SendUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0002*\u0004\u0018\u00010\u00050\u00052*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "kotlin.jvm.PlatformType", "", "attachmentParts", "Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.SendUtils$getSendPayload$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<List<FileUpload>, SendPayload.ReadyToSend> {
        public final /* synthetic */ RestAPIParams.Message $sanitizedApiParamMessage;

        public AnonymousClass2(RestAPIParams.Message message) {
            this.$sanitizedApiParamMessage = message;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ SendPayload.ReadyToSend call(List<FileUpload> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final SendPayload.ReadyToSend call2(List<FileUpload> list) {
            RestAPIParams.Message message = this.$sanitizedApiParamMessage;
            Intrinsics3.checkNotNullExpressionValue(list, "attachmentParts");
            return new SendPayload.ReadyToSend(message, list);
        }
    }

    /* compiled from: SendUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/app/AppFragment;", "<anonymous parameter 0>", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "", "invoke", "(Lcom/discord/app/AppFragment;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.SendUtils$handleCaptchaRequired$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ MessageQueue4.CaptchaRequired $messageResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MessageQueue4.CaptchaRequired captchaRequired) {
            super(2);
            this.$messageResult = captchaRequired;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
            StoreStream.INSTANCE.getMessages().resendMessageWithCaptcha(this.$messageResult.getChannelId(), this.$messageResult.getNonce(), captchaPayload);
        }
    }

    /* compiled from: SendUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.SendUtils$handleCaptchaRequired$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MessageQueue4.CaptchaRequired $messageResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MessageQueue4.CaptchaRequired captchaRequired) {
            super(0);
            this.$messageResult = captchaRequired;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getMessages().markMessageFailed(this.$messageResult.getChannelId(), this.$messageResult.getNonce());
        }
    }

    /* compiled from: SendUtils.kt */
    @DebugMetadata(c = "com.discord.utilities.rest.SendUtils$uniqueifyNames$1", f = "SendUtils.kt", l = {204, 206}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ld0/f0/k;", "Lcom/lytefast/flexinput/model/Attachment;", "", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.SendUtils$uniqueifyNames$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super Attachment<? extends Object>>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List $attachmentParts;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, Continuation continuation) {
            super(2, continuation);
            this.$attachmentParts = list;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$attachmentParts, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceBuilder2<? super Attachment<? extends Object>> sequenceBuilder2, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceBuilder2, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SequenceBuilder2 sequenceBuilder2;
            AnonymousClass1 anonymousClass1;
            Map map;
            Iterator it;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                SequenceBuilder2 sequenceBuilder22 = (SequenceBuilder2) this.L$0;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                sequenceBuilder2 = sequenceBuilder22;
                anonymousClass1 = this;
                map = linkedHashMap;
                it = this.$attachmentParts.iterator();
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                map = (Map) this.L$1;
                sequenceBuilder2 = (SequenceBuilder2) this.L$0;
                Result3.throwOnFailure(obj);
                anonymousClass1 = this;
            }
            while (it.hasNext()) {
                Attachment attachment = (Attachment) it.next();
                Object objBoxInt = map.get(attachment.getDisplayName());
                if (objBoxInt == null) {
                    objBoxInt = boxing.boxInt(0);
                }
                int iIntValue = ((Number) objBoxInt).intValue();
                map.put(attachment.getDisplayName(), boxing.boxInt(iIntValue + 1));
                if (iIntValue == 0) {
                    anonymousClass1.L$0 = sequenceBuilder2;
                    anonymousClass1.L$1 = map;
                    anonymousClass1.L$2 = it;
                    anonymousClass1.label = 1;
                    if (sequenceBuilder2.yield(attachment, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Attachment attachmentRenamedWithDuplicateCount = SendUtils.INSTANCE.renamedWithDuplicateCount(attachment, iIntValue);
                    anonymousClass1.L$0 = sequenceBuilder2;
                    anonymousClass1.L$1 = map;
                    anonymousClass1.L$2 = it;
                    anonymousClass1.label = 2;
                    if (sequenceBuilder2.yield(attachmentRenamedWithDuplicateCount, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.a;
        }
    }

    private SendUtils() {
    }

    private final Observable<FileUpload> getPart(Attachment<?> attachment, ContentResolver contentResolver, String str) {
        return Observable.o(new AnonymousClass1(attachment, str, contentResolver), Emitter.BackpressureMode.BUFFER);
    }

    private final SendPayload.Preprocessing getPreprocessingFromAttachments(ContentResolver contentResolver, List<? extends Attachment<?>> fileAttachments) {
        if (fileAttachments.size() != 1) {
            return new SendPayload.Preprocessing(fileAttachments.size(), null, null);
        }
        Attachment<?> attachment = (Attachment) _Collections.first((List) fileAttachments);
        return new SendPayload.Preprocessing(1, Attachment.INSTANCE.a(attachment), AttachmentUtils.getMimeType(contentResolver, attachment.getUri(), attachment.getDisplayName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleSendError$default(SendUtils sendUtils, Error error, Context context, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function02 = null;
        }
        sendUtils.handleSendError(error, context, function0, function02);
    }

    private final Tuples2<String, String> splitFileExtension(String str) {
        int iLastIndexOf$default = Strings4.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return Tuples.to(str, null);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strSubstring2 = str.substring(iLastIndexOf$default + 1);
        Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return Tuples.to(strSubstring, strSubstring2);
    }

    public final void compressImageAttachments(Context context, List<? extends Attachment<?>> attachments, Function1<? super List<? extends Attachment<?>>, Unit> onCompressed) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attachments, "attachments");
        Intrinsics3.checkNotNullParameter(onCompressed, "onCompressed");
        CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        f.H0(coroutineScope2, MainDispatchers.f3830b, null, new AnonymousClass1(attachments, context, onCompressed, null), 2, null);
    }

    public final Observable<SendPayload> getSendCommandPayload(ContentResolver contentResolver, ApplicationCommandLocalSendData apiParamMessage, List<? extends Attachment<?>> attachments) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(apiParamMessage, "apiParamMessage");
        if (attachments == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new SendPayload.ReadyToSendCommand(apiParamMessage, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return scalarSynchronousObservable;
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(attachments);
        ApplicationCommandLocalSendData applicationCommandLocalSendDataCopy$default = ApplicationCommandLocalSendData.copy$default(apiParamMessage, 0L, 0L, null, null, null, null, null, null, StoreApplicationCommandsKt.mapApplicationCommandValues(apiParamMessage.getApplicationCommandsValues(), new SendUtils4(listUniqueifyNames)), null, null, 1791, null);
        if (!(!listUniqueifyNames.isEmpty())) {
            ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new SendPayload.ReadyToSendCommand(applicationCommandLocalSendDataCopy$default, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(SendPayl…tedMessage, emptyList()))");
            return scalarSynchronousObservable2;
        }
        ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, "files[" + i + ']'));
            i = i2;
        }
        Observable<SendPayload> observableM = Observable.m(scalarSynchronousObservable3, Observable.l(arrayList).f0().G(new AnonymousClass2(applicationCommandLocalSendDataCopy$default)));
        Intrinsics3.checkNotNullExpressionValue(observableM, "Observable.concat(\n     …)\n              }\n      )");
        return observableM;
    }

    public final Observable<SendPayload> getSendPayload(ContentResolver contentResolver, RestAPIParams.Message apiParamMessage, List<? extends Attachment<?>> attachments) {
        String str;
        List<Attachment<?>> list;
        RestAPIParams.Message messageCopy$default = apiParamMessage;
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(messageCopy$default, "apiParamMessage");
        if (attachments == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new SendPayload.ReadyToSend(messageCopy$default, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return scalarSynchronousObservable;
        }
        List<Attachment<?>> listExtractLinks = AttachmentUtils.extractLinks(attachments, contentResolver);
        String content = apiParamMessage.getContent();
        if (content == null) {
            content = "";
        }
        String strAppendLinks = AttachmentUtils.appendLinks(content, listExtractLinks);
        if (!Intrinsics3.areEqual(strAppendLinks, apiParamMessage.getContent())) {
            str = "Observable.just(SendPayl…ramMessage, emptyList()))";
            list = listExtractLinks;
            messageCopy$default = RestAPIParams.Message.copy$default(apiParamMessage, strAppendLinks, null, null, null, null, null, null, null, null, 510, null);
        } else {
            str = "Observable.just(SendPayl…ramMessage, emptyList()))";
            list = listExtractLinks;
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(_Collections.minus((Iterable) attachments, (Iterable) list));
        if (!(!listUniqueifyNames.isEmpty())) {
            ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new SendPayload.ReadyToSend(messageCopy$default, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, str);
            return scalarSynchronousObservable2;
        }
        ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, outline.q("file", i)));
            i = i2;
        }
        Observable<SendPayload> observableM = Observable.m(scalarSynchronousObservable3, Observable.l(arrayList).f0().G(new AnonymousClass2(messageCopy$default)));
        Intrinsics3.checkNotNullExpressionValue(observableM, "Observable.concat(\n     …)\n              }\n      )");
        return observableM;
    }

    public final void handleCaptchaRequired(MessageQueue4.CaptchaRequired messageResult) {
        Intrinsics3.checkNotNullParameter(messageResult, "messageResult");
        WidgetCaptchaBottomSheet.INSTANCE.enqueue("Message Captcha", new AnonymousClass1(messageResult), new AnonymousClass2(messageResult), CaptchaErrorBody.INSTANCE.createFromError(messageResult.getError()));
    }

    @MainThread
    public final void handleSendError(Error error, Context context, Function0<Unit> filesTooLargeCallback, Function0<Unit> failedDeliveryToRecipientCallback) {
        Intrinsics3.checkNotNullParameter(error, "error");
        Intrinsics3.checkNotNullParameter(context, "context");
        error.setShowErrorToasts(false);
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        if (abortCodeMessageResId != null) {
            AppToast.g(context, abortCodeMessageResId.intValue(), 0, null, 12);
        } else if (error.getType() == Error.Type.REQUEST_TOO_LARGE) {
            if (filesTooLargeCallback != null) {
                filesTooLargeCallback.invoke();
            }
        } else if (error.getType() != Error.Type.FORBIDDEN_DISCORD) {
            Error.Response response2 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
            if (response2.isKnownResponse() || error.getType() == Error.Type.NETWORK) {
                error.setShowErrorToasts(true);
            } else {
                AppToast.g(context, R.string.network_error_bad_request, 0, null, 12);
            }
        } else if (failedDeliveryToRecipientCallback != null) {
            failedDeliveryToRecipientCallback.invoke();
        }
        error.showToasts(context);
    }

    @VisibleForTesting
    public final <T> Attachment<T> renamedWithDuplicateCount(Attachment<? extends T> attachment, int i) {
        String str;
        Intrinsics3.checkNotNullParameter(attachment, "$this$renamedWithDuplicateCount");
        long id2 = attachment.getId();
        Uri uri = attachment.getUri();
        Tuples2<String, String> tuples2SplitFileExtension = splitFileExtension(attachment.getDisplayName());
        String strComponent1 = tuples2SplitFileExtension.component1();
        String strComponent2 = tuples2SplitFileExtension.component2();
        if (strComponent2 != null) {
            str = strComponent1 + '-' + i + '.' + strComponent2;
        } else {
            str = strComponent1 + '-' + i;
        }
        return new Attachment<>(id2, uri, str, attachment.getData(), false, 16, null);
    }

    @VisibleForTesting
    public final List<Attachment<?>> uniqueifyNames(List<? extends Attachment<?>> attachmentParts) {
        Intrinsics3.checkNotNullParameter(attachmentParts, "attachmentParts");
        return _Sequences2.toList(SequenceBuilder3.sequence(new AnonymousClass1(attachmentParts, null)));
    }
}
