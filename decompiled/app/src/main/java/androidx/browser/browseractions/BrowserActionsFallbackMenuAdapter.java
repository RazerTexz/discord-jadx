package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.browser.R;
import androidx.core.content.res.ResourcesCompat;
import b.i.b.d.a.ListenableFuture8;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Deprecated
/* loaded from: classes.dex */
public class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ ListenableFuture8 val$bitmapFuture;
        public final /* synthetic */ String val$titleText;
        public final /* synthetic */ ViewHolderItem val$viewHolder;

        public AnonymousClass1(String str, ViewHolderItem viewHolderItem, ListenableFuture8 listenableFuture8) {
            this.val$titleText = str;
            this.val$viewHolder = viewHolderItem;
            this.val$bitmapFuture = listenableFuture8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            if (TextUtils.equals(this.val$titleText, this.val$viewHolder.mText.getText())) {
                try {
                    bitmap = (Bitmap) this.val$bitmapFuture.get();
                } catch (InterruptedException | ExecutionException unused) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    this.val$viewHolder.mIcon.setVisibility(0);
                    this.val$viewHolder.mIcon.setImageBitmap(bitmap);
                } else {
                    this.val$viewHolder.mIcon.setVisibility(4);
                    this.val$viewHolder.mIcon.setImageBitmap(null);
                }
            }
        }
    }

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements Executor {
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public static class ViewHolderItem {
        public final ImageView mIcon;
        public final TextView mText;

        public ViewHolderItem(ImageView imageView, TextView textView) {
            this.mIcon = imageView;
            this.mText = textView;
        }
    }

    public BrowserActionsFallbackMenuAdapter(List<BrowserActionItem> list, Context context) {
        this.mMenuItems = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mMenuItems.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mMenuItems.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        ViewHolderItem viewHolderItem;
        BrowserActionItem browserActionItem = this.mMenuItems.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.browser_actions_context_menu_row, (ViewGroup) null);
            ImageView imageView = (ImageView) view.findViewById(R.id.browser_actions_menu_item_icon);
            TextView textView = (TextView) view.findViewById(R.id.browser_actions_menu_item_text);
            if (imageView == null || textView == null) {
                throw new IllegalStateException("Browser Actions fallback UI does not contain necessary Views.");
            }
            viewHolderItem = new ViewHolderItem(imageView, textView);
            view.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) view.getTag();
        }
        String title = browserActionItem.getTitle();
        viewHolderItem.mText.setText(title);
        if (browserActionItem.getIconId() != 0) {
            viewHolderItem.mIcon.setImageDrawable(ResourcesCompat.getDrawable(this.mContext.getResources(), browserActionItem.getIconId(), null));
        } else if (browserActionItem.getIconUri() != null) {
            ListenableFuture8<Bitmap> listenableFuture8LoadBitmap = BrowserServiceFileProvider.loadBitmap(this.mContext.getContentResolver(), browserActionItem.getIconUri());
            listenableFuture8LoadBitmap.addListener(new AnonymousClass1(title, viewHolderItem, listenableFuture8LoadBitmap), new AnonymousClass2());
        } else {
            viewHolderItem.mIcon.setImageBitmap(null);
            viewHolderItem.mIcon.setVisibility(4);
        }
        return view;
    }
}
