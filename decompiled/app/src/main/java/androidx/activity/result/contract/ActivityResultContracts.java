package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ActivityResultContracts {

    @TargetApi(19)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String str) {
            return createIntent2(context, str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return getSynchronousResult2(context, str);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ Uri parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.CREATE_DOCUMENT").setType("*/*").putExtra("android.intent.extra.TITLE", str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String str) {
            return createIntent2(context, str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return getSynchronousResult2(context, str);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ Uri parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(18)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        @NonNull
        public static List<Uri> getClipDataUris(@NonNull Intent intent) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (intent.getData() != null) {
                linkedHashSet.add(intent.getData());
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return Collections.emptyList();
            }
            if (clipData != null) {
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    Uri uri = clipData.getItemAt(i).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String str) {
            return createIntent2(context, str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return getSynchronousResult2(context, str);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int i, @Nullable Intent intent) {
            return parseResult2(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        /* renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int i, @Nullable Intent intent) {
            return (intent == null || i != -1) ? Collections.emptyList() : getClipDataUris(intent);
        }
    }

    @TargetApi(19)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return createIntent2(context, strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String[] strArr) {
            return getSynchronousResult2(context, strArr);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(@NonNull Context context, @NonNull String[] strArr) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ Uri parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull String[] strArr) {
            return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @Nullable Uri uri) {
            return createIntent2(context, uri);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(@NonNull Context context, @Nullable Uri uri) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @Nullable Uri uri) {
            return getSynchronousResult2(context, uri);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ Uri parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @Nullable Uri uri) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(19)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return createIntent2(context, strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context context, @NonNull String[] strArr) {
            return getSynchronousResult2(context, strArr);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(@NonNull Context context, @NonNull String[] strArr) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int i, @Nullable Intent intent) {
            return parseResult2(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull String[] strArr) {
            return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        /* renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int i, @Nullable Intent intent) {
            return (i != -1 || intent == null) ? Collections.emptyList() : GetMultipleContents.getClipDataUris(intent);
        }
    }

    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @Nullable Void r2) {
            return createIntent2(context, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ Uri parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @Nullable Void r2) {
            return new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public Uri parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return createIntent2(context, strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(@NonNull Context context, @Nullable String[] strArr) {
            return getSynchronousResult2(context, strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Map<String, Boolean> parseResult(int i, @Nullable Intent intent) {
            return parseResult2(i, intent);
        }

        @NonNull
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull String[] strArr) {
            return createIntent(strArr);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult2(@NonNull Context context, @Nullable String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(Collections.emptyMap());
            }
            ArrayMap arrayMap = new ArrayMap();
            boolean z2 = true;
            for (String str : strArr) {
                boolean z3 = ContextCompat.checkSelfPermission(context, str) == 0;
                arrayMap.put(str, Boolean.valueOf(z3));
                if (!z3) {
                    z2 = false;
                }
            }
            if (z2) {
                return new ActivityResultContract.SynchronousResult<>(arrayMap);
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        /* renamed from: parseResult, reason: avoid collision after fix types in other method */
        public Map<String, Boolean> parseResult2(int i, @Nullable Intent intent) {
            if (i != -1) {
                return Collections.emptyMap();
            }
            if (intent == null) {
                return Collections.emptyMap();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            int length = stringArrayExtra.length;
            for (int i2 = 0; i2 < length; i2++) {
                map.put(stringArrayExtra[i2], Boolean.valueOf(intArrayExtra[i2] == 0));
            }
            return map;
        }

        @NonNull
        public static Intent createIntent(@NonNull String[] strArr) {
            return new Intent(ACTION_REQUEST_PERMISSIONS).putExtra(EXTRA_PERMISSIONS, strArr);
        }
    }

    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull String str) {
            return createIntent2(context, str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NonNull Context context, @Nullable String str) {
            return getSynchronousResult2(context, str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Boolean parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull String str) {
            return RequestMultiplePermissions.createIntent(new String[]{str});
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(@NonNull Context context, @Nullable String str) {
            if (str == null) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.FALSE);
            }
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public Boolean parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || intArrayExtra.length == 0) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(intArrayExtra[0] == 0);
        }
    }

    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @NonNull
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull Intent intent) {
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull Intent intent) {
            return createIntent2(context, intent);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public ActivityResult parseResult(int i, @Nullable Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull IntentSenderRequest intentSenderRequest) {
            return createIntent2(context, intentSenderRequest);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull IntentSenderRequest intentSenderRequest) {
            return new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public ActivityResult parseResult(int i, @Nullable Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull Uri uri) {
            return createIntent2(context, uri);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(@NonNull Context context, @NonNull Uri uri) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NonNull Context context, @NonNull Uri uri) {
            return getSynchronousResult2(context, uri);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public /* bridge */ /* synthetic */ Boolean parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull Uri uri) {
            return new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public final Boolean parseResult(int i, @Nullable Intent intent) {
            return Boolean.valueOf(i == -1);
        }
    }

    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @Nullable Void r2) {
            return createIntent2(context, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@NonNull Context context, @Nullable Void r2) {
            return getSynchronousResult2(context, r2);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult2(@NonNull Context context, @Nullable Void r2) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ Bitmap parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @Nullable Void r2) {
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Bitmap parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return (Bitmap) intent.getParcelableExtra("data");
        }
    }

    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public /* bridge */ /* synthetic */ Intent createIntent(@NonNull Context context, @NonNull Uri uri) {
            return createIntent2(context, uri);
        }

        @Nullable
        /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult2(@NonNull Context context, @NonNull Uri uri) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@NonNull Context context, @NonNull Uri uri) {
            return getSynchronousResult2(context, uri);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public /* bridge */ /* synthetic */ Bitmap parseResult(int i, @Nullable Intent intent) {
            return parseResult(i, intent);
        }

        @NonNull
        @CallSuper
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@NonNull Context context, @NonNull Uri uri) {
            return new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Bitmap parseResult(int i, @Nullable Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return (Bitmap) intent.getParcelableExtra("data");
        }
    }

    private ActivityResultContracts() {
    }
}
