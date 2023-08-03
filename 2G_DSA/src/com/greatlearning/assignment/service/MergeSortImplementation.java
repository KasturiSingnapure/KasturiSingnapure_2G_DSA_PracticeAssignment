package com.greatlearning.assignment.service;

public class MergeSortImplementation {

	public void merge(boolean profitArray[], double arr[], int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];

		boolean leftProfitArray[] = new boolean[n1];
		boolean rightProfitArray[] = new boolean[n2];

		for (int i = 0; i < n1; ++i) {
			leftArray[i] = arr[left + i];
			leftProfitArray[i] = profitArray[left + i];
		}
		for (int j = 0; j < n2; ++j) {
			rightArray[j] = arr[mid + 1 + j];
			rightProfitArray[j] = profitArray[mid + 1 + j];
		}
		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				profitArray[k] = leftProfitArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				profitArray[k] = rightProfitArray[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public void sort(boolean profitArray[], double arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			sort(profitArray, arr, left, mid);
			sort(profitArray, arr, mid + 1, right);

			merge(profitArray, arr, left, mid, right);
		}
	}

}
