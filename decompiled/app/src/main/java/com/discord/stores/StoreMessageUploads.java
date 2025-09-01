package com.discord.stores;

import b.d.b.a.outline;
import com.discord.utilities.rest.SendUtils;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreMessageUploads.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0010\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0015\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R:\u0010\u0014\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\u0017j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0005`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/discord/stores/StoreMessageUploads;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/stores/Nonce;", "nonce", "Lcom/discord/stores/StoreMessageUploads$MessageUploadState;", "uploadState", "", "updateState", "(Ljava/lang/String;Lcom/discord/stores/StoreMessageUploads$MessageUploadState;)V", "getUploadProgress", "(Ljava/lang/String;)Lcom/discord/stores/StoreMessageUploads$MessageUploadState;", "", "numFiles", "displayName", "mimeType", "onPreprocessing", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "uploads", "bindUpload", "(Ljava/lang/String;Ljava/util/List;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "<init>", "()V", "MessageUploadState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMessageUploads extends StoreV2 {
    private final HashMap<String, MessageUploadState> uploads = new HashMap<>();

    /* compiled from: StoreMessageUploads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreMessageUploads$MessageUploadState;", "", "<init>", "()V", "None", "Preprocessing", "Uploading", "Lcom/discord/stores/StoreMessageUploads$MessageUploadState$None;", "Lcom/discord/stores/StoreMessageUploads$MessageUploadState$Preprocessing;", "Lcom/discord/stores/StoreMessageUploads$MessageUploadState$Uploading;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class MessageUploadState {

        /* compiled from: StoreMessageUploads.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreMessageUploads$MessageUploadState$None;", "Lcom/discord/stores/StoreMessageUploads$MessageUploadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class None extends MessageUploadState {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        /* compiled from: StoreMessageUploads.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreMessageUploads$MessageUploadState$Preprocessing;", "Lcom/discord/stores/StoreMessageUploads$MessageUploadState;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "numFiles", "displayName", "mimeType", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lcom/discord/stores/StoreMessageUploads$MessageUploadState$Preprocessing;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getNumFiles", "Ljava/lang/String;", "getDisplayName", "getMimeType", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Preprocessing extends MessageUploadState {
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

        /* compiled from: StoreMessageUploads.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreMessageUploads$MessageUploadState$Uploading;", "Lcom/discord/stores/StoreMessageUploads$MessageUploadState;", "", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "component1", "()Ljava/util/List;", "uploads", "copy", "(Ljava/util/List;)Lcom/discord/stores/StoreMessageUploads$MessageUploadState$Uploading;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getUploads", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Uploading extends MessageUploadState {
            private final List<SendUtils.FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Uploading(List<SendUtils.FileUpload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Uploading copy$default(Uploading uploading, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = uploading.uploads;
                }
                return uploading.copy(list);
            }

            public final List<SendUtils.FileUpload> component1() {
                return this.uploads;
            }

            public final Uploading copy(List<SendUtils.FileUpload> uploads) {
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new Uploading(uploads);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Uploading) && Intrinsics3.areEqual(this.uploads, ((Uploading) other).uploads);
                }
                return true;
            }

            public final List<SendUtils.FileUpload> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                List<SendUtils.FileUpload> list = this.uploads;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Uploading(uploads="), this.uploads, ")");
            }
        }

        private MessageUploadState() {
        }

        public /* synthetic */ MessageUploadState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Store3
    private final void updateState(String nonce, MessageUploadState uploadState) {
        this.uploads.put(nonce, uploadState);
        markChanged();
    }

    @Store3
    public final void bindUpload(String nonce, List<SendUtils.FileUpload> uploads) {
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        Intrinsics3.checkNotNullParameter(uploads, "uploads");
        updateState(nonce, new MessageUploadState.Uploading(uploads));
    }

    public final MessageUploadState getUploadProgress(String nonce) {
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        MessageUploadState messageUploadState = this.uploads.get(nonce);
        return messageUploadState != null ? messageUploadState : MessageUploadState.None.INSTANCE;
    }

    @Store3
    public final void onPreprocessing(String nonce, int numFiles, String displayName, String mimeType) {
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        updateState(nonce, new MessageUploadState.Preprocessing(numFiles, displayName, mimeType));
    }
}
