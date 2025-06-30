// getComputedStyle(element)

Example:
let element = document.querySelector("button");
let computedStyle = window.getComputedStyle(element);
let buttonBgColor = computedStyle.backgroundColor;

// Note :
// Here we should specify the target-element
// It gives the applied CSS style of the element
// Here we can use window.getComputedStyle(selected-Elelement) or we can derectly use getComputedStyle(selected-Element)

