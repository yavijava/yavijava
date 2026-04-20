package com.vmware.vim.cf;

import com.vmware.vim25.PropertyFilterUpdate;

@FunctionalInterface
interface PropertyFilterUpdateListener {
    void onUpdate(PropertyFilterUpdate[] updates);
}
