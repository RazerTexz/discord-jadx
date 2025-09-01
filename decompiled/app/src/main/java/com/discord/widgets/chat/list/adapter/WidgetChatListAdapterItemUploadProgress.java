package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChatListAdapterItemUploadProgressBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreMessageUploads;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.file.FileUtils2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.UploadProgressView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.UploadProgressEntry;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$LongRef;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "uploadState", "", "configureUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;)V", "Lcom/discord/views/UploadProgressView;", "setUploadState", "(Lcom/discord/views/UploadProgressView;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "Lcom/discord/databinding/WidgetChatListAdapterItemUploadProgressBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemUploadProgressBinding;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Companion", ExifInterface.TAG_MODEL, "ModelProvider", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress extends WidgetChatListItem {
    private static final long MODEL_THROTTLE_MS = 100;
    private final WidgetChatListAdapterItemUploadProgressBinding binding;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "", "<init>", "()V", "Companion", "Few", "Many", "None", "Preprocessing", "Single", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$None;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Preprocessing;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Single;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Few;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Many;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Model {
        public static final int PROGRESS_INDETERMINATE = -1;
        public static final long SIZE_UNKNOWN = -1;

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Few;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Single;", "component1", "()Ljava/util/List;", "uploads", "copy", "(Ljava/util/List;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Few;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getUploads", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Few extends Model {
            private final List<Single> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Few(List<Single> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Few copy$default(Few few, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = few.uploads;
                }
                return few.copy(list);
            }

            public final List<Single> component1() {
                return this.uploads;
            }

            public final Few copy(List<Single> uploads) {
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new Few(uploads);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Few) && Intrinsics3.areEqual(this.uploads, ((Few) other).uploads);
                }
                return true;
            }

            public final List<Single> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                List<Single> list = this.uploads;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Few(uploads="), this.uploads, ")");
            }
        }

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Many;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "", "component1", "()I", "", "component2", "()J", "component3", "numFiles", "sizeBytes", "progress", "copy", "(IJI)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Many;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getProgress", "J", "getSizeBytes", "getNumFiles", "<init>", "(IJI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Many extends Model {
            private final int numFiles;
            private final int progress;
            private final long sizeBytes;

            public Many(int i, long j, int i2) {
                super(null);
                this.numFiles = i;
                this.sizeBytes = j;
                this.progress = i2;
            }

            public static /* synthetic */ Many copy$default(Many many, int i, long j, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = many.numFiles;
                }
                if ((i3 & 2) != 0) {
                    j = many.sizeBytes;
                }
                if ((i3 & 4) != 0) {
                    i2 = many.progress;
                }
                return many.copy(i, j, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* renamed from: component2, reason: from getter */
            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            /* renamed from: component3, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            public final Many copy(int numFiles, long sizeBytes, int progress) {
                return new Many(numFiles, sizeBytes, progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Many)) {
                    return false;
                }
                Many many = (Many) other;
                return this.numFiles == many.numFiles && this.sizeBytes == many.sizeBytes && this.progress == many.progress;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public final int getProgress() {
                return this.progress;
            }

            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            public int hashCode() {
                return ((b.a(this.sizeBytes) + (this.numFiles * 31)) * 31) + this.progress;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Many(numFiles=");
                sbU.append(this.numFiles);
                sbU.append(", sizeBytes=");
                sbU.append(this.sizeBytes);
                sbU.append(", progress=");
                return outline.B(sbU, this.progress, ")");
            }
        }

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$None;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class None extends Model {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Preprocessing;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "numFiles", "displayName", "mimeType", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Preprocessing;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMimeType", "I", "getNumFiles", "getDisplayName", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Preprocessing extends Model {
            private final String displayName;
            private final String mimeType;
            private final int numFiles;

            public Preprocessing(int i, String str, String str2) {
                super(null);
                this.numFiles = i;
                this.displayName = str;
                this.mimeType = str2;
            }

            public static /* synthetic */ Preprocessing copy$default(Preprocessing preprocessing, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = preprocessing.numFiles;
                }
                if ((i2 & 2) != 0) {
                    str = preprocessing.displayName;
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
            public final String getDisplayName() {
                return this.displayName;
            }

            /* renamed from: component3, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            public final Preprocessing copy(int numFiles, String displayName, String mimeType) {
                return new Preprocessing(numFiles, displayName, mimeType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Preprocessing)) {
                    return false;
                }
                Preprocessing preprocessing = (Preprocessing) other;
                return this.numFiles == preprocessing.numFiles && Intrinsics3.areEqual(this.displayName, preprocessing.displayName) && Intrinsics3.areEqual(this.mimeType, preprocessing.mimeType);
            }

            public final String getDisplayName() {
                return this.displayName;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public int hashCode() {
                int i = this.numFiles * 31;
                String str = this.displayName;
                int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mimeType;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Preprocessing(numFiles=");
                sbU.append(this.numFiles);
                sbU.append(", displayName=");
                sbU.append(this.displayName);
                sbU.append(", mimeType=");
                return outline.J(sbU, this.mimeType, ")");
            }
        }

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000bJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Single;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "", "component4", "()I", ModelAuditLogEntry.CHANGE_KEY_NAME, "mimeType", "sizeBytes", "progress", "copy", "(Ljava/lang/String;Ljava/lang/String;JI)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Single;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSizeBytes", "Ljava/lang/String;", "getName", "getMimeType", "I", "getProgress", "<init>", "(Ljava/lang/String;Ljava/lang/String;JI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Single extends Model {
            private final String mimeType;
            private final String name;
            private final int progress;
            private final long sizeBytes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Single(String str, String str2, long j, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(str2, "mimeType");
                this.name = str;
                this.mimeType = str2;
                this.sizeBytes = j;
                this.progress = i;
            }

            public static /* synthetic */ Single copy$default(Single single, String str, String str2, long j, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = single.name;
                }
                if ((i2 & 2) != 0) {
                    str2 = single.mimeType;
                }
                String str3 = str2;
                if ((i2 & 4) != 0) {
                    j = single.sizeBytes;
                }
                long j2 = j;
                if ((i2 & 8) != 0) {
                    i = single.progress;
                }
                return single.copy(str, str3, j2, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* renamed from: component2, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            /* renamed from: component3, reason: from getter */
            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            /* renamed from: component4, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            public final Single copy(String name, String mimeType, long sizeBytes, int progress) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
                return new Single(name, mimeType, sizeBytes, progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Single)) {
                    return false;
                }
                Single single = (Single) other;
                return Intrinsics3.areEqual(this.name, single.name) && Intrinsics3.areEqual(this.mimeType, single.mimeType) && this.sizeBytes == single.sizeBytes && this.progress == single.progress;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final String getName() {
                return this.name;
            }

            public final int getProgress() {
                return this.progress;
            }

            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            public int hashCode() {
                String str = this.name;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.mimeType;
                return ((b.a(this.sizeBytes) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.progress;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Single(name=");
                sbU.append(this.name);
                sbU.append(", mimeType=");
                sbU.append(this.mimeType);
                sbU.append(", sizeBytes=");
                sbU.append(this.sizeBytes);
                sbU.append(", progress=");
                return outline.B(sbU, this.progress, ")");
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$ModelProvider;", "", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "upload", "", "throttleIntervalMs", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Single;", "getSingleUploadObservable", "(Lcom/discord/utilities/rest/SendUtils$FileUpload;J)Lrx/Observable;", "", "uploads", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Few;", "getFewUploadsObservable", "(Ljava/util/List;J)Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model$Many;", "getManyUploadsObservable", "bytesWritten", "contentLengthBytes", "", "getPercentage", "(JJ)I", "", "nonce", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "get", "(Ljava/lang/String;J)Lrx/Observable;", "MAX_DETAILED_UPLOADS", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();
        private static final int MAX_DETAILED_UPLOADS = 3;

        private ModelProvider() {
        }

        public static final /* synthetic */ Observable access$getFewUploadsObservable(ModelProvider modelProvider, List list, long j) {
            return modelProvider.getFewUploadsObservable(list, j);
        }

        public static final /* synthetic */ Observable access$getManyUploadsObservable(ModelProvider modelProvider, List list, long j) {
            return modelProvider.getManyUploadsObservable(list, j);
        }

        public static final /* synthetic */ int access$getPercentage(ModelProvider modelProvider, long j, long j2) {
            return modelProvider.getPercentage(j, j2);
        }

        public static final /* synthetic */ Observable access$getSingleUploadObservable(ModelProvider modelProvider, SendUtils.FileUpload fileUpload, long j) {
            return modelProvider.getSingleUploadObservable(fileUpload, j);
        }

        private final Observable<Model.Few> getFewUploadsObservable(List<SendUtils.FileUpload> uploads, long throttleIntervalMs) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.getSingleUploadObservable((SendUtils.FileUpload) it.next(), throttleIntervalMs));
            }
            Observable<Model.Few> observableB = Observable.b(arrayList, WidgetChatListAdapterItemUploadProgress$ModelProvider$getFewUploadsObservable$2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableB, "Observable\n          .co…{ it as Model.Single }) }");
            return observableB;
        }

        private final Observable<Model.Many> getManyUploadsObservable(List<SendUtils.FileUpload> uploads, long throttleIntervalMs) {
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = 0L;
            for (SendUtils.FileUpload fileUpload : uploads) {
                if (fileUpload.getContentLength() <= 0) {
                    ref$LongRef.element = -1L;
                } else {
                    ref$LongRef.element = fileUpload.getContentLength() + ref$LongRef.element;
                }
            }
            if (ref$LongRef.element <= 0) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new Model.Many(uploads.size(), -1L, -1));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n            .…          )\n            )");
                return scalarSynchronousObservable;
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(ObservableExtensionsKt.leadingEdgeThrottle(((SendUtils.FileUpload) it.next()).getBytesWrittenObservable(), throttleIntervalMs, TimeUnit.MILLISECONDS));
            }
            Observable<Model.Many> observableG = Observable.b(arrayList, WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3.INSTANCE).G(new WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$4(ref$LongRef)).r().G(new WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$5(uploads, ref$LongRef));
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable\n            .…essPercent)\n            }");
            return observableG;
        }

        private final int getPercentage(long bytesWritten, long contentLengthBytes) {
            float f = bytesWritten;
            if (contentLengthBytes > 0) {
                return (int) ((f / contentLengthBytes) * 100);
            }
            Logger.e$default(AppLog.g, "contentLengthBytes was not positive", new Exception(), null, 4, null);
            return 0;
        }

        private final Observable<Model.Single> getSingleUploadObservable(SendUtils.FileUpload upload, long throttleIntervalMs) {
            if (upload.getContentLength() <= 0) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new Model.Single(upload.getName(), upload.getMimeType(), -1L, -1));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(\n       …E\n            )\n        )");
                return scalarSynchronousObservable;
            }
            Observable<Model.Single> observableG = ObservableExtensionsKt.leadingEdgeThrottle(upload.getBytesWrittenObservable(), throttleIntervalMs, TimeUnit.MILLISECONDS).G(new WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1(upload)).r().G(new WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$2(upload));
            Intrinsics3.checkNotNullExpressionValue(observableG, "upload\n            .byte…          )\n            }");
            return observableG;
        }

        public final Observable<? extends Model> get(String nonce, long throttleIntervalMs) {
            Intrinsics3.checkNotNullParameter(nonce, "nonce");
            StoreMessageUploads messageUploads = StoreStream.INSTANCE.getMessageUploads();
            Observable<? extends Model> observableY = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{messageUploads}, false, null, null, new WidgetChatListAdapterItemUploadProgress$ModelProvider$get$1(messageUploads, nonce), 14, null).Y(new WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2(throttleIntervalMs));
            Intrinsics3.checkNotNullExpressionValue(observableY, "ObservationDeckProvider.…      }\n        }\n      }");
            return observableY;
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress) {
            super(1, widgetChatListAdapterItemUploadProgress, WidgetChatListAdapterItemUploadProgress.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemUploadProgress.access$configureUI((WidgetChatListAdapterItemUploadProgress) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemUploadProgress.access$setSubscription$p(WidgetChatListAdapterItemUploadProgress.this, subscription);
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Function0 $cancel;

        public AnonymousClass3(Function0 function0) {
            this.$cancel = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$cancel.invoke();
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Function0 $cancel;

        public AnonymousClass4(Function0 function0) {
            this.$cancel = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$cancel.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemUploadProgress(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_upload_progress, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.progress_cancel_centered;
        ImageView imageView = (ImageView) view.findViewById(R.id.progress_cancel_centered);
        if (imageView != null) {
            i = R.id.progress_cancel_top;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.progress_cancel_top);
            if (imageView2 != null) {
                i = R.id.upload_progress_1;
                UploadProgressView uploadProgressView = (UploadProgressView) view.findViewById(R.id.upload_progress_1);
                if (uploadProgressView != null) {
                    i = R.id.upload_progress_2;
                    UploadProgressView uploadProgressView2 = (UploadProgressView) view.findViewById(R.id.upload_progress_2);
                    if (uploadProgressView2 != null) {
                        i = R.id.upload_progress_3;
                        UploadProgressView uploadProgressView3 = (UploadProgressView) view.findViewById(R.id.upload_progress_3);
                        if (uploadProgressView3 != null) {
                            WidgetChatListAdapterItemUploadProgressBinding widgetChatListAdapterItemUploadProgressBinding = new WidgetChatListAdapterItemUploadProgressBinding((LinearLayout) view, imageView, imageView2, uploadProgressView, uploadProgressView2, uploadProgressView3);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemUploadProgressBinding, "WidgetChatListAdapterIte…essBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemUploadProgressBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress, Model model) throws Resources.NotFoundException {
        widgetChatListAdapterItemUploadProgress.configureUI(model);
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress) {
        return widgetChatListAdapterItemUploadProgress.subscription;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress, Subscription subscription) {
        widgetChatListAdapterItemUploadProgress.subscription = subscription;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(Model uploadState) throws Resources.NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4 = uploadState instanceof Model.Few;
        if (z4) {
            UploadProgressView uploadProgressView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView, "binding.uploadProgress1");
            Model.Few few = (Model.Few) uploadState;
            setUploadState(uploadProgressView, few.getUploads().get(0));
            UploadProgressView uploadProgressView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView2, "binding.uploadProgress2");
            setUploadState(uploadProgressView2, few.getUploads().get(1));
            UploadProgressView uploadProgressView3 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView3, "binding.uploadProgress3");
            uploadProgressView3.setVisibility(0);
            if (few.getUploads().size() == 3) {
                UploadProgressView uploadProgressView4 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView4, "binding.uploadProgress3");
                uploadProgressView4.setVisibility(0);
                UploadProgressView uploadProgressView5 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView5, "binding.uploadProgress3");
                setUploadState(uploadProgressView5, few.getUploads().get(2));
            } else {
                UploadProgressView uploadProgressView6 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView6, "binding.uploadProgress3");
                uploadProgressView6.setVisibility(8);
            }
        } else {
            UploadProgressView uploadProgressView7 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView7, "binding.uploadProgress1");
            setUploadState(uploadProgressView7, uploadState);
            UploadProgressView uploadProgressView8 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView8, "binding.uploadProgress2");
            uploadProgressView8.setVisibility(8);
            UploadProgressView uploadProgressView9 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView9, "binding.uploadProgress3");
            uploadProgressView9.setVisibility(8);
        }
        if ((uploadState instanceof Model.Preprocessing) || ((uploadState instanceof Model.Single) && ((Model.Single) uploadState).getProgress() < 100)) {
            z2 = true;
        } else if (z4) {
            List<Model.Single> uploads = ((Model.Few) uploadState).getUploads();
            if ((uploads instanceof Collection) && uploads.isEmpty()) {
                z3 = false;
                if (z3) {
                }
            } else {
                Iterator<T> it = uploads.iterator();
                while (it.hasNext()) {
                    if (((Model.Single) it.next()).getProgress() < 100) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (z3) {
                    if (!(uploadState instanceof Model.Many) || ((Model.Many) uploadState).getProgress() >= 100) {
                        z2 = false;
                    }
                }
            }
        }
        if (z2) {
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.progressCancelTop");
            imageView.setVisibility(z4 ? 0 : 8);
            ImageView imageView2 = this.binding.f2342b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.progressCancelCentered");
            imageView2.setVisibility(z4 ^ true ? 0 : 8);
            return;
        }
        ImageView imageView3 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.progressCancelTop");
        imageView3.setVisibility(8);
        ImageView imageView4 = this.binding.f2342b;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.progressCancelCentered");
        imageView4.setVisibility(8);
    }

    private final void setUploadState(UploadProgressView uploadProgressView, Model model) throws Resources.NotFoundException {
        if (Intrinsics3.areEqual(model, Model.None.INSTANCE)) {
            CharSequence charSequenceJ = FormatUtils.j(uploadProgressView, R.string.upload_queued, new Object[0], null, 4);
            int i = UploadProgressView.j;
            uploadProgressView.a(charSequenceJ, 0, null);
            Context context = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_uploads_generic, 0, 2, (Object) null));
            return;
        }
        if (model instanceof Model.Preprocessing) {
            Model.Preprocessing preprocessing = (Model.Preprocessing) model;
            CharSequence displayName = preprocessing.getDisplayName();
            if (displayName == null) {
                Resources resources = uploadProgressView.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                Context context2 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "context");
                displayName = StringResourceUtils.getQuantityString(resources, context2, R.plurals.uploading_files_count, preprocessing.getNumFiles(), Integer.valueOf(preprocessing.getNumFiles()));
            }
            int i2 = UploadProgressView.j;
            uploadProgressView.a(displayName, -1, null);
            if (preprocessing.getMimeType() != null) {
                Context context3 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context3, "context");
                uploadProgressView.setIcon(FileUtils2.getIconForFiletype(context3, preprocessing.getMimeType()));
                return;
            } else {
                Context context4 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context4, "context");
                uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context4, R.attr.ic_uploads_generic, 0, 2, (Object) null));
                return;
            }
        }
        if (model instanceof Model.Single) {
            Model.Single single = (Model.Single) model;
            uploadProgressView.a(single.getName(), single.getProgress() != -1 ? single.getProgress() : -1, FileUtils2.getSizeSubtitle(single.getSizeBytes()));
            Context context5 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context5, "context");
            uploadProgressView.setIcon(FileUtils2.getIconForFiletype(context5, single.getMimeType()));
            return;
        }
        if (model instanceof Model.Many) {
            Resources resources2 = uploadProgressView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            Context context6 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context6, "context");
            Model.Many many = (Model.Many) model;
            uploadProgressView.a(StringResourceUtils.getQuantityString(resources2, context6, R.plurals.uploading_files_count, many.getNumFiles(), Integer.valueOf(many.getNumFiles())), many.getProgress() != -1 ? many.getProgress() : -1, FileUtils2.getSizeSubtitle(many.getSizeBytes()));
            Context context7 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context7, "context");
            uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context7, R.attr.ic_uploads_generic, 0, 2, (Object) null));
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        Observable<? extends Model> observableL = ModelProvider.INSTANCE.get(((UploadProgressEntry) data).getMessageNonce(), 100L).L();
        Intrinsics3.checkNotNullExpressionValue(observableL, "ModelProvider.get(data.m…  .onBackpressureLatest()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableL), WidgetChatListAdapterItemUploadProgress.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 58, (Object) null);
        WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 = new WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1(data);
        this.binding.c.setOnClickListener(new AnonymousClass3(widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1));
        this.binding.f2342b.setOnClickListener(new AnonymousClass4(widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1));
    }
}
